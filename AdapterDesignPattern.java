interface PaymentProcess {
    void processPayment(int amount, String currency, String gatewayChoice);
}

class PaypalGateway {
    public void makePayment(int amount, String currency) {
        System.out.println("Paypal Payment - Amount: " + amount + " Currency: " + currency);
    }
}

class StripeGateway {
    public void paymentInDollars(int amount) {
        System.out.println("Stripe Payment - Dollars Payment: " + amount);
    }
}

class PaymentAdapter implements PaymentProcess {
    private PaypalGateway paypalGateway;
    private StripeGateway stripeGateway;

    public PaymentAdapter(PaypalGateway pGateway, StripeGateway sGateway) {
        this.paypalGateway = pGateway;
        this.stripeGateway = sGateway;
    }

    @Override
    public void processPayment(int amount, String currency, String gatewayChoice) {
        if (gatewayChoice.equals("Paypal")) {
            paypalGateway.makePayment(amount, currency);
        } else if (gatewayChoice.equals("Stripe")) {
            if (currency.equalsIgnoreCase("DOLLARS")) {
                stripeGateway.paymentInDollars(amount);
            } else {
                System.out.println("Stripe only supports DOLLARS. Payment failed.");
            }
        } else {
            System.out.println("Invalid gateway choice: " + gatewayChoice);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaypalGateway paypalGateway = new PaypalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        PaymentAdapter paymentAdapter = new PaymentAdapter(paypalGateway, stripeGateway);
        paymentAdapter.processPayment(1000, "DOLLARS", "Paypal");
        paymentAdapter.processPayment(1000, "DOLLARS", "Stripe");
        paymentAdapter.processPayment(1000, "EUROS", "Stripe");
        paymentAdapter.processPayment(1000, "DOLLARS", "InvalidGateway");
    }
}
