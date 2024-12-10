interface Car{
    void carInfo();
}

interface Bike{
    void bikeInfo();
}

class PetrolCar implements Car{
    public void carInfo(){
        System.out.println("This is petrol car.");
    }
}

class ElectricCar implements Car{
    public void carInfo(){
        System.out.println("This is electric car.");
    }
}

class PetrolBike implements Bike{
    public void bikeInfo(){
        System.out.println("This is petrol bike.");
    }
}

class ElectricBike implements Bike{
    public void bikeInfo(){
        System.out.println("This is electric bike.");
    }
}

interface VehicleFactory{
    Car createCar();
    Bike createBike();
}

class PetrolFactoryClass implements VehicleFactory{
    public Car createCar(){
        return new PetrolCar();
    }
    public Bike createBike(){
        return new PetrolBike();
    }
}

class ElectricFactoryClass implements VehicleFactory{
    public Car createCar(){
        return new ElectricCar();
    }
    public Bike createBike(){
        return new ElectricBike();
    }
}

class Application{
    private Car car;
    private Bike bike;
    public Application(VehicleFactory factory){
        car=factory.createCar();
        bike=factory.createBike();
    }
    
    public void display(){
        car.carInfo();
        bike.bikeInfo();
    }
}

class Main {
    public static void main(String[] args) {
        Application petrolApp=new Application(new PetrolFactoryClass());
        petrolApp.display();
        
        Application electricApp=new Application(new ElectricFactoryClass());
        electricApp.display();
    }
}
