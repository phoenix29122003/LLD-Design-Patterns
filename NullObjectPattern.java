import java.util.Map;         
import java.util.HashMap;

interface Product{
    void viewDetails();
}

class ElectronicsProduct implements Product{
    private String productName,productCategory;
    private int productPrice;
    public ElectronicsProduct(String pname,String pcategory,int pprice){
        this.productName=pname;
        this.productCategory=pcategory;
        this.productPrice=pprice;
    }
    public void viewDetails(){
        System.out.println("Product Name: "+productName);
        System.out.println("Product Category: "+productCategory);
        System.out.println("Product Price: "+productPrice);
    }
}

class ClothingProduct implements Product{
    private String productName,productCategory;
    private int productPrice;
    public ClothingProduct(String pname,String pcategory,int pprice){
        this.productName=pname;
        this.productCategory=pcategory;
        this.productPrice=pprice;
    }
    public void viewDetails(){
        System.out.println("Product Name: "+productName);
        System.out.println("Product Category: "+productCategory);
        System.out.println("Product Price: "+productPrice);
    }
}

class NullProduct implements Product{
    public void viewDetails(){
        System.out.println("Product not available.")
    }
}

class StoreSystem{
    private Map<String,Product>mp;
    public StoreSystem(){
        mp=new HashMap<>();
        mp.put("phone",new ElectronicsProduct("phone","electronic",30000));
        mp.put("laptop",new ElectronicsProduct("laptop","electronic",100000));
        mp.put("earphones",new ElectronicsProduct("earphones","electronic",500));
        mp.put("jeans",new ClothingProduct("jeans","clothing",1000));
        mp.put("shirt",new ClothingProduct("shirt","clothing",500));
    }
    public Product getProduct(String productName){
        return mp.getOrDefault(productName,new NullProduct());
    }
}

class Main {
    public static void main(String[] args) {
        StoreSystem shop=new StoreSystem();
        
        Product product1=shop.getProduct("phone");
        product1.viewDetails();
        
        Product product2=shop.getProduct("null object");
        product2.viewDetails();
    }
}
