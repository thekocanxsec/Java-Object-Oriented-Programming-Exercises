interface TaxStrategy {
    double calculateTax(double amount);
}

class BosniaTax implements TaxStrategy{
    @Override
    public double calculateTax(double amount){
        return amount * 0.17;
    }
}

class UsTax implements TaxStrategy{
    @Override
    public double calculateTax(double amount){
        return amount * 0.08 + 5.0;
    }
}

class DigitalExemptTaxStrategy implements TaxStrategy{
    @Override
    public double calculateTax(double amount){
        return 0.0;
    }
}

class Order{
    private TaxStrategy taxStrategy;
    private Double basePrice;
    private String name;

    public Order(Double basePrice, String name){
        this.basePrice = basePrice;
        this.name = name;
    }

    public Double getBasePrice(){
        return this.basePrice;
    }

    public String getName(){
        return this.name;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy){
        this.taxStrategy = taxStrategy;
    }

    public void printReciept(){
        double tax = taxStrategy.calculateTax(getBasePrice());
        double result = tax + getBasePrice();

        System.out.println("Product: " + this.name);
        System.out.println("Base Price: " + this.basePrice);
        System.out.println("Tax: " + tax);
        System.out.println("Total to pay: " + result);
    }

}

class MainRun{
    static void main() {
        Order order1 = new Order(20.0, "Coffee");

        order1.setTaxStrategy(new BosniaTax());

        order1.printReciept();
    }
}
