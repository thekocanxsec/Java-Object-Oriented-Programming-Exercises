interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;

    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }

}

class PayPalPayment implements PaymentStrategy{
    private String email;

    public PayPalPayment(String email){
        this.email = email;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

class ShoppingCart{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        if(paymentStrategy == null){
            System.out.println("Please select a payment method first!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

class MainRun9{
    static void main() {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("330 250 230 211"));
        cart.checkout(150);

        cart.setPaymentStrategy(new CreditCardPayment("imran@gmail.com"));
        cart.checkout(200);

    }
}