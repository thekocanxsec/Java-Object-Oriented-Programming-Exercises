interface ShippingStrategy {
    double calculatePrice(double weight);
}

class StandardShipping implements ShippingStrategy{
    @Override
    public double calculatePrice(double weight){
        return 5.0;
    }

}

class ExpressShipping implements ShippingStrategy{
    @Override
    public double calculatePrice(double weight){
        return weight * 5.0 + 10.0;
    }

}

class InPersonPickup implements ShippingStrategy{
    @Override
    public double calculatePrice(double weight){
        return 0.0;
    }
}

class Order{
    private ShippingStrategy shippingStrategy;


    public double processOrder(double weight){
        return shippingStrategy.calculatePrice(weight);
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }
}

class MainRun10{
    static void main() {
        Order order1 = new Order();

        order1.setShippingStrategy(new ExpressShipping());
        double price = order1.processOrder(10.0);
        System.out.println("Price: " + price);

    }
}