package Inheritance;

public class Task1 {
}

class Item{
    private String name;
    private int price;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public double calculateTax(){
        return 0.0;
    }
}

class Chocolate extends Item{
    private double cocoaPercentage;

    public Chocolate(String name, int price, double cocoaPercentage){
        super(name, price);
        this.cocoaPercentage = cocoaPercentage;
    }

    @Override
    public double calculateTax(){
        return (double)getPrice() * 0.12;
    }
}

class Cigarettes extends Item{
    private double nicotinePercentage;

    public Cigarettes(String name, int price, double nicotinePercentage){
        super(name,price);
        this.nicotinePercentage = nicotinePercentage;
    }

    @Override
    public double calculateTax(){
        return (double)getPrice() * 0.89;
    }

}

class MainRun{
    static void main(String[] args) {
        Chocolate chocolate = new Chocolate("Mars", 12, 87.0);
        Cigarettes cigarettes = new Cigarettes("Marlboro", 6,90.1);

        System.out.println(chocolate.calculateTax());
        System.out.println(cigarettes.calculateTax());
    }
}
