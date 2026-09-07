import java.util.List;
import java.util.ArrayList;

public class Task11 {
}

interface Serviceable{
    void service();
}

abstract class Vehicle1 implements Serviceable{
    private String brand;
    private int year;

    public Vehicle1(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    public String getBrand(){
        return this.brand;
    }

    public int getYear(){
        return this.year;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setYear(int year){
        this.year = year;
    }


}

class Car extends Vehicle1{
    private int doors;

    public Car(String brand, int year, int doors){
        super(brand,year);
        this.doors = doors;
    }

    @Override
    public void service(){
        System.out.println("Car serviced");
    }

    public int getDoors(){
        return this.doors;
    }

    public void setDoors(int doors){
        this.doors = doors;
    }
}

class Truck extends Vehicle1{
    private double loadCapacity;

    public Truck(String brand, int year, double loadCapacity){
        super(brand,year);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity(){
        return this.loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity){
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void service(){
        System.out.println("Truck serviced");
    }


}

class VehicleRegistry{
    public void performService(List<Serviceable> vehicles){
        for(Serviceable vehicle : vehicles){
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                car.setDoors(4);
            }
            else if(vehicle instanceof Truck){
                Truck truck = (Truck) vehicle;
                truck.setLoadCapacity(10.0);
            }
            else{
                System.out.println("Vehicle type not found.");
            }
        }

    }
}



class MainRun11 {
    public static void main(String[] args) {
        List<Serviceable> vehicles = new ArrayList<>();

        Car car = new Car("Audi", 2020, 2);
        Truck truck = new Truck("Volvo", 2018, 5.0);

        vehicles.add(car);
        vehicles.add(truck);

        System.out.println("--- Before performService ---");
        System.out.println("Car doors: " + car.getDoors());
        System.out.println("Truck load capacity: " + truck.getLoadCapacity());

        VehicleRegistry registry = new VehicleRegistry();
        registry.performService(vehicles);

        System.out.println("\n--- After performService (Car doors -> 4, Truck load -> 10.0) ---");
        System.out.println("Car doors: " + car.getDoors());
        System.out.println("Truck load capacity: " + truck.getLoadCapacity());
    }
}