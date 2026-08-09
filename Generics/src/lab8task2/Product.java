package lab8task2;

public class Product<T extends Comparable<T>>{
    private String name;
    private T price;

    public Product(String name, T price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public T getPrice(){
        return this.price;
    }

    public String comparePrice(Product<T> other){
        int comparsion = this.price.compareTo(other.getPrice());

        if(comparsion > 0){
            return "Item " + this.name + " is more expensive than " + other.getName();
        }
        else if(comparsion < 0){
            return "Item " + this.name + " is cheaper than " + other.getName();
        }
        else{
            return "Items are same price.";
        }
    }

}