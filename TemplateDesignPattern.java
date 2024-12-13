abstract class Kitchen{
    public final void prepareRecipe(){
        collectIngredients();
        prepareFood();
        addCondiments();
        packFood();
    }
    protected abstract void collectIngredients();
    protected abstract void prepareFood();
    protected abstract void addCondiments();
    private void packFood(){
        System.out.println("Packing Order");
    }
}

class preparePizza extends Kitchen{
    @Override
    protected void collectIngredients(){
        System.out.println("Collecting dough, cheese, sauce, toppings.");
    }
    @Override
    protected void prepareFood(){
        System.out.println("Bake the pizza");
    }
    @Override
    protected void addCondiments(){
        System.out.println("Add pizza condiments like herbs or extra toppings.");
    }
}

class prepareBurger extends Kitchen{
    @Override
    protected void collectIngredients(){
        System.out.println("Collecting buns, patty, vegetables, sauces.");
    }
    @Override
    protected void prepareFood(){
        System.out.println("Grill the patty and assemble the burger.");
    }
    @Override
    protected void addCondiments(){
        System.out.println("Add ketchup, mustard, or other sauces");
    }
}

class prepareSalad extends Kitchen{
    @Override
    protected void collectIngredients(){
        System.out.println("Collecting vegetables, lettuce, dressing.");
    }
    @Override
    protected void prepareFood(){
        System.out.println("Mix the vegetables");
    }
    @Override
    protected void addCondiments(){
        System.out.println("Add dressing and seasonings.");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Preparing Pizza-->");
        Kitchen pizza=new preparePizza();
        pizza.prepareRecipe();
        
        System.out.println("Preparing Burger-->");
        Kitchen burger=new prepareBurger();
        burger.prepareRecipe();
        
        System.out.println("Preparing Salad-->");
        Kitchen salad=new prepareSalad();
        salad.prepareRecipe();
    }
}
