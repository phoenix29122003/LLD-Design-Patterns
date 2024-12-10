interface Pizza{
    String getDescription();
    double getCost();
}

class BasePizza implements Pizza{
    public String getDescription(){
        return "Base Pizza";
    }
    public double getCost(){
        return 100.00;
    }
}

abstract class PizzaToppingsDecorator implements Pizza{
    protected Pizza pizza;
    public PizzaToppingsDecorator(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public String getDescription(){
        return pizza.getDescription();
    }
    @Override
    public double getCost(){
        return pizza.getCost();
    }
}

class Cheese extends PizzaToppingsDecorator{
    public Cheese(Pizza pizza){
        super(pizza);
    }
    @Override 
    public String getDescription(){
        return pizza.getDescription()+" + Cheese";
    }
    @Override
    public double getCost(){
        return pizza.getCost()+50.00;
    }
}

class Pepperoni extends PizzaToppingsDecorator{
    public Pepperoni(Pizza pizza){
        super(pizza);
    }
    @Override 
    public String getDescription(){
        return pizza.getDescription()+" + Pepperoni";
    }
    @Override
    public double getCost(){
        return pizza.getCost()+40.00;
    }
}

class ExtraSauce extends PizzaToppingsDecorator{
    public ExtraSauce(Pizza pizza){
        super(pizza);
    }
    @Override 
    public String getDescription(){
        return pizza.getDescription()+" + Extra Sauce";
    }
    @Override
    public double getCost(){
        return pizza.getCost()+30.00;
    }
}

class Olives extends PizzaToppingsDecorator{
    public Olives(Pizza pizza){
        super(pizza);
    }
    @Override 
    public String getDescription(){
        return pizza.getDescription()+" + Olives";
    }
    @Override
    public double getCost(){
        return pizza.getCost()+20.00;
    }
}

class Bacon extends PizzaToppingsDecorator{
    public Bacon(Pizza pizza){
        super(pizza);
    }
    @Override 
    public String getDescription(){
        return pizza.getDescription()+" + Bacon";
    }
    @Override
    public double getCost(){
        return pizza.getCost()+10.00;
    }
}


class Main {
    public static void main(String[] args) {
        BasePizza basePizza=new BasePizza();
        System.out.println(basePizza.getDescription()+": "+basePizza.getCost());
        
        Cheese cheesePizza=new Cheese(basePizza);
        System.out.println(cheesePizza.getDescription()+": "+cheesePizza.getCost());
        
        Pepperoni pepperoniPizza=new Pepperoni(cheesePizza);
        System.out.println(pepperoniPizza.getDescription()+": "+pepperoniPizza.getCost());
        
        ExtraSauce extraSaucePizza=new ExtraSauce(pepperoniPizza);
        System.out.println(extraSaucePizza.getDescription()+": "+extraSaucePizza.getCost());
        
        Olives olivePizza=new Olives(extraSaucePizza);
        System.out.println(olivePizza.getDescription()+": "+olivePizza.getCost());
        
        Bacon baconPizza=new Bacon(olivePizza);
        System.out.println(baconPizza.getDescription()+": "+baconPizza.getCost());
    }
}
