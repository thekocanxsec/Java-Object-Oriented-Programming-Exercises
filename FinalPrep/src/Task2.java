class Task2 {
}


class Item{
    private String name;
    private int price;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
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
        return (double)this.getPrice() * 0.12;
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
        return (double)this.getPrice() * 0.89;
    }

}

class MainRun2 {
    public static void main(String[] args) {
        // Test base Item class and default tax (0.0)
        Item genericItem = new Item("Notebook", 100);
        System.out.println(genericItem.getName() + " Tax: " + genericItem.calculateTax());

        // Test Chocolate subclass and tax calculation (12% of price)
        Chocolate chocolate = new Chocolate("Dark Chocolate", 50, 70.5);
        System.out.println(chocolate.getName() + " Tax: " + chocolate.calculateTax()); // Expected: 6.0

        // Test Cigarettes subclass and tax calculation (89% of price)
        Cigarettes cigarettes = new Cigarettes("Brand X", 200, 1.2);
        System.out.println(cigarettes.getName() + " Tax: " + cigarettes.calculateTax()); // Expected: 178.0

        // Test polymorphism with an array of Items
        Item[] items = {genericItem, chocolate, cigarettes};
        System.out.println("\n--- Polymorphism Test ---");
        for (Item item : items) {
            System.out.println(item.getName() + " tax: " + item.calculateTax());
        }
    }
}