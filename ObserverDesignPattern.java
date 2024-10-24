import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(int jobOpening);
}

interface JobAlertNotification{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class JobAlertSystem implements JobAlertNotification{
    private List<Observer>observerList=new ArrayList<>();
    private int jobOpening;
    @Override
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }
    @Override
    public void notifyObservers(){
        for(Observer observer:observerList){
            observer.update(jobOpening);
        }
    }
    public void setJobOpening(int numOfVacancy){
        this.jobOpening=numOfVacancy;
        notifyObservers();
    }
}

class PhoneAlert implements Observer{
    private int jobOpening;
    @Override
    public void update(int jobOpening){
        this.jobOpening=jobOpening;
        display();
    }
    public void display(){
        System.out.println("Updated Job Vacancy on Phone: "+ jobOpening);
    }
}

class LaptopAlert implements Observer{
    private int jobOpening;
    @Override
    public void update(int jobOpening){
        this.jobOpening=jobOpening;
        display();
    }
    public void display(){
        System.out.println("Updated Job Vacancy on Laptop: "+ jobOpening);
    }
}

public class Main {
    public static void main(String[] args) {
        JobAlertSystem JobAlertSystem = new JobAlertSystem();
        Observer PhoneAlert=new PhoneAlert();
        Observer LaptopAlert=new LaptopAlert();
        JobAlertSystem.addObserver(PhoneAlert);
        JobAlertSystem.addObserver(LaptopAlert);
        JobAlertSystem.setJobOpening(5);
    }
}
