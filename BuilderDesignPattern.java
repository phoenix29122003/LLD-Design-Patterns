import java.util.*;

class Pizza {
    private String pizzaSize, pizzaCrust;
    private List<String> pizzaToppings = new ArrayList<>();
    private boolean hasExtraCheese = false;
    
    public Pizza(String size, String crust) {
        this.pizzaSize = size;
        this.pizzaCrust = crust;
    }
    
    public void addToppings(String topping) {
        pizzaToppings.add(topping);
    }
    
    public void addExtraCheese() {
        this.hasExtraCheese = true;
    }
    
    public void display() {
        System.out.print("Prepared pizza has toppings: ");
        for (String topping : pizzaToppings) {
            System.out.print(topping + " ");
        }
        System.out.println();
        System.out.println("Pizza Size: " + pizzaSize);
        System.out.println("Pizza Crust Type: " + pizzaCrust);
        System.out.println("Extra Cheese: " + (hasExtraCheese ? "Yes" : "No"));
    }
}

class PizzaBuilder {
    private Pizza pizza;
    
    public PizzaBuilder(String size, String crust) {
        pizza = new Pizza(size, crust);
    }
    
    public PizzaBuilder addToppings(String topping) {
        pizza.addToppings(topping);
        return this;
    }
    
    public PizzaBuilder addExtraCheese() {
        pizza.addExtraCheese();
        return this;
    }
    
    public Pizza build() {
        return pizza;
    }
}

class Main {
    public static void main(String[] args) {
        PizzaBuilder builder = new PizzaBuilder("Large", "Thin");
        builder.addToppings("Pepperoni")
               .addToppings("Mushrooms")
               .addExtraCheese();
        
        Pizza pizza = builder.build();
        pizza.display();
    }
}
