class AlgorithmContext{
    private AlgorithmStrategy algorithmStrategy;
    public AlgorithmContext(AlgorithmStrategy algorithmStrategy){
        this.algorithmStrategy=algorithmStrategy;
    }
    public void setAlgorithmStrategy(AlgorithmStrategy algorithmStrategy){
        this.algorithmStrategy=algorithmStrategy;
    }
    public void performAlgo(){
        algorithmStrategy.run();
    }
}

interface AlgorithmStrategy{
    void run();
}

class RecurrsiveAlgorithm implements AlgorithmStrategy{
    @Override
    public void run(){
        System.out.println("This is recurssion.");
    }
}

class MemoizationAlgorithm implements AlgorithmStrategy{
    @Override
    public void run(){
        System.out.println("This is memoization.");
    }
}

class TabulationAlgorithm implements AlgorithmStrategy{
    @Override
    public void run(){
        System.out.println("This is tabulation.");
    }
}

public class Main {
    public static void main(String[] args){
        AlgorithmContext obj=new AlgorithmContext(new RecurrsiveAlgorithm());
        obj.performAlgo();
        
        obj.setAlgorithmStrategy(new MemoizationAlgorithm());
        obj.performAlgo();
        
        obj.setAlgorithmStrategy(new TabulationAlgorithm());
        obj.performAlgo();
    }
}
