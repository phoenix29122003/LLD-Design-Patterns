interface BankAccount {
    void checkBalance(String username, String password);
    void withdrawlAmmount(String username, String password, int amount);
}

class RealBankAccount implements BankAccount {
    private int bankBalance = 10000;

    @Override
    public void checkBalance(String username, String password) {
        System.out.println("Current Bank Balance is: " + bankBalance);
    }

    @Override
    public void withdrawlAmmount(String username, String password, int amount) {
        if (bankBalance >= amount) {
            bankBalance -= amount;
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("Current Balance after Withdrawal: " + bankBalance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }
}

class ProxyBankAccount implements BankAccount {
    private String username = "manu";
    private String password = "Ayodhya@123";
    private RealBankAccount realBankAccount;

    private boolean authenticate(String uname, String pword) {
        if (username.equals(uname) && password.equals(pword)) {
            if (realBankAccount == null) {
                realBankAccount = new RealBankAccount();
            }
            return true;
        }
        return false;
    }

    @Override
    public void checkBalance(String uname, String pword) {
        if (authenticate(uname, pword)) {
            realBankAccount.checkBalance(uname, pword);
        } else {
            System.out.println("Invalid Username or Password.");
        }
    }

    @Override
    public void withdrawlAmmount(String uname, String pword, int amount) {
        if (authenticate(uname, pword)) {
            realBankAccount.withdrawlAmmount(uname, pword, amount);
        } else {
            System.out.println("Unauthorized Access. Cannot Withdraw.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ProxyBankAccount proxyAccount = new ProxyBankAccount();

        // Successful Case
        System.out.println("Case 1: Valid Credentials");
        proxyAccount.checkBalance("manu", "Ayodhya@123");
        proxyAccount.withdrawlAmmount("manu", "Ayodhya@123", 1000);

        // Failed Authentication Case
        System.out.println("\nCase 2: Invalid Credentials");
        proxyAccount.checkBalance("manu", "wrongpassword");
        proxyAccount.withdrawlAmmount("manu", "wrongpassword", 500);
    }
}
