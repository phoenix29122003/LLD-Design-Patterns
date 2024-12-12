import java.util.ArrayList;
import java.util.List;

interface MenuComponent{
    void setName(String name);
    void displayInfo();
}

class MenuItem implements MenuComponent{
    private String itemName;
    private int itemPrice;
    public MenuItem(String name,int price){
        this.itemName=name;
        this.itemPrice=price;
    }
    public void setName(String name){
        itemName=name;
    }
    public void displayInfo(){
        System.out.println("Item Name: "+itemName+" Item Price: "+itemPrice);
    }
}

class MenuSection implements MenuComponent{
    private String sectionName;
    private List<MenuComponent>itemList=new ArrayList<>();
    
    public MenuSection(String name){
        this.sectionName=name;
    }
    public void setName(String name){
        sectionName=name;
    }
    public void addItem(MenuComponent component){
        itemList.add(component);
    }
    public void removeItem(MenuComponent component){
        itemList.remove(component);
    }
    public void displayInfo(){
        System.out.println("Menu Section Name: "+sectionName);
        for(MenuComponent compo:itemList){
            compo.displayInfo();
        }
    }
}

class Main {
    public static void main(String[] args) {
        MenuItem item1=new MenuItem("Pizza",100);
        MenuItem item2=new MenuItem("Burger",50);
        MenuItem item3=new MenuItem("Pasta",100);
        MenuSection section1=new MenuSection("Main Course");
        section1.addItem(item1);
        section1.addItem(item2);
        section1.addItem(item3);
        
        MenuItem item4=new MenuItem("Coffee",40);
        MenuItem item5=new MenuItem("Tea",30);
        MenuSection section2=new MenuSection("Drinks");
        section2.addItem(item4);
        section2.addItem(item5);
        
        MenuItem item6=new MenuItem("Ice Cream",40);
        MenuItem item7=new MenuItem("Cake",300);
        MenuSection section3=new MenuSection("Desserts");
        section3.addItem(item6);
        section3.addItem(item7);
        
        MenuSection section4=new MenuSection("Main Menu");
        section4.addItem(section1);
        section4.addItem(section2);
        section4.addItem(section3);
        
        section4.displayInfo();
    }
}
