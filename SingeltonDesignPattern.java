class Main {
    private static volatile Main mainInstance;
    private Main() {}
    public static Main getInstance(){
        if(mainInstance==null){
            synchronized(Main.class){
                if(mainInstance==null){
                    mainInstance=new Main();
                }
            }
        }
        return mainInstance;
    }
    
    public void showInstance(){
        System.out.println("Instance Created: "+this);
    }
    
    public static void main(String[] args) {
        Runnable task=()->{
            Main mainInstance=Main.getInstance();
            mainInstance.showInstance();
        };
        
        Thread thread1=new Thread(task);
        Thread thread2=new Thread(task);
        Thread thread3=new Thread(task);
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try{
            thread1.join();
            thread2.join();
            thread3.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
