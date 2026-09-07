public class Task6Generics {
}

class  Product1<T extends Comparable<T>>{
    private String name;
    private T price;

    public Product1(String name,T price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public T getPrice(){
        return this.price;
    }

    public String comparePrice(Product1<T> other){
        int result = this.getPrice().compareTo(other.getPrice());

        if (result > 0) {
            return "Product " + this.name + " is more expensive than " + other.name;
        } else if (result < 0) {
            return "Product " + this.name + " is cheaper than " + other.name;
        } else {
            return "Product " + this.name + " and " + other.name + " have the same price";
        }

    }
}

