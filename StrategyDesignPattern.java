interface DiscountStrategy{
	int applyDiscount(int totalAmount);
}

class NoDiscountStrategy implements DiscountStrategy{
	@Override
	public int applyDiscount(int totalAmount){
    	return totalAmount;
    }
}

class SeasonalDiscountStrategy implements DiscountStrategy{
	@Override
	public int applyDiscount(int totalAmount){
    	return totalAmount-(int)(totalAmount*0.2);
    }
}

class MembershipDiscountStrategy implements DiscountStrategy{
    @Override
	public int applyDiscount(int totalAmount){
    	return totalAmount-(int)(totalAmount*0.3);
    }
}

class PromotionalDiscountStrategy implements DiscountStrategy{
    @Override
	public int applyDiscount(int totalAmount){
    	return totalAmount-(int)(totalAmount*0.5);
    }
}

class DiscountContext{
	private DiscountStrategy discountStrategy;
    public void setDiscountStrategy(DiscountStrategy discountStrategy){
    	this.discountStrategy=discountStrategy;
    }
    
    public int amountAfterDiscount(int totalAmount){
    	if(discountStrategy==null){
        	System.out.println("Please set discount strategy");
            return -1;
        }
    	return discountStrategy.applyDiscount(totalAmount);	
    }
}

public class Main {
  public static void main(String[] args) {
    	DiscountContext discountApplier=new DiscountContext();
        
        discountApplier.setDiscountStrategy(new NoDiscountStrategy());
        System.out.println("Amount after no discount: "+discountApplier.amountAfterDiscount(1150));
        
        discountApplier.setDiscountStrategy(new SeasonalDiscountStrategy());
        System.out.println("Amount after seasonal discount: "+discountApplier.amountAfterDiscount(1150));
        
        discountApplier.setDiscountStrategy(new MembershipDiscountStrategy());
        System.out.println("Amount after membership discount: "+discountApplier.amountAfterDiscount(1150));
        
        discountApplier.setDiscountStrategy(new PromotionalDiscountStrategy());
        System.out.println("Amount after promotional discount: "+discountApplier.amountAfterDiscount(1150));
  }
}
