import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car implements Comparable<Car>{
    private String model;
    private int price;

    public Car(String model,int price){
        this.model = model;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Car other){
        return Integer.compare(this.price, other.getPrice());
    }
}

class Main{
    static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("Mercedes", 20000));
        carList.add(new Car("Audi", 18000));
        carList.add(new Car("BMW", 15000));
        carList.add(new Car("Opel", 10000));

        Collections.sort(carList);

        Car findCar = new Car("Mercedes", 20000);
        int index = Collections.binarySearch(carList,findCar);

        System.out.println("Car was found on index: " + index);
    }
}
