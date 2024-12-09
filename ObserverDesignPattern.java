import java.util.ArrayList;
import java.util.List;

interface StockSubject{
    void addObserver(StockObserver stockObserver);
    void removeObserver(StockObserver stockObserver);
    void notifyObserver();
}

interface StockObserver{
    void update(String stockName,int stockPrice);
}

class ConcreteStockObserver implements StockObserver{
    private String stockObserverName;
    public ConcreteStockObserver(String stockObserverName){
        this.stockObserverName=stockObserverName;
    }
    @Override
    public void update(String stockName,int currentPrice){
        System.out.println(stockObserverName+" receives a notification with stock name "+stockName+ " and price "+currentPrice);
    }
}

class ConcreteStockSubject implements StockSubject{
    private List<StockObserver>stockObserverList=new ArrayList<>();
    private String stockName;
    private int stockPrice;
    public ConcreteStockSubject(String stockName){
        this.stockName=stockName;
    }
    @Override
    public void addObserver(StockObserver stockObserver){
        stockObserverList.add(stockObserver);
    }
    @Override
    public void removeObserver(StockObserver stockObserver){
        stockObserverList.remove(stockObserver);
    }
    public void setStockPrice(int stockPrice){
        this.stockPrice=stockPrice;
        notifyObserver();
    }
    @Override
    public void notifyObserver(){
        for(StockObserver observer:stockObserverList){
            observer.update(stockName,stockPrice);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ConcreteStockSubject stock1=new ConcreteStockSubject("Stock1");
        ConcreteStockSubject stock2=new ConcreteStockSubject("Stock2");
        
        StockObserver observer1=new ConcreteStockObserver("monty");
        StockObserver observer2=new ConcreteStockObserver("tom");
        StockObserver observer3=new ConcreteStockObserver("jerry");
        StockObserver observer4=new ConcreteStockObserver("jack");
        
        stock1.addObserver(observer1);
        stock1.addObserver(observer2);
        
        stock2.addObserver(observer3);
        stock2.addObserver(observer4);
        
        stock1.setStockPrice(100);
        stock2.setStockPrice(200);
        
        stock1.removeObserver(observer1);
        stock2.removeObserver(observer3);
        
        stock1.setStockPrice(300);
        stock2.setStockPrice(400);
    }
}
