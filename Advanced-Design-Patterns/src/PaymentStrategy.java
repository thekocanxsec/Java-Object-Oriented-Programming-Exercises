interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " via CreditCard." );
    }
}

class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " via PayPal." );
    }
}

class ShoppingCart{
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
        return;
    }

    public void checkout(int amount){
        strategy.pay(amount);
    }
}

class MainRun6{
    static void main() {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new PayPalPayment());

        cart.checkout(200);
    }
}