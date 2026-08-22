interface DiscountStrategy {
    double applyDiscount(double amount);
}

class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount){
        return amount;
    }
}

class HolidayDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount){
        return amount - 10.0;
    }
}

class VipDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount){
        return amount * 0.8;
    }
}

class Shopping{
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public double checkout(double amount){
        return discountStrategy.applyDiscount(amount);
    }

}

class MainRun11{
    static void main() {
        Shopping shoppingCart = new Shopping();

        shoppingCart.setDiscountStrategy(new HolidayDiscount());
        double price = shoppingCart.checkout(20.0);

        System.out.println("Total with discount: " + price);
    }
}
