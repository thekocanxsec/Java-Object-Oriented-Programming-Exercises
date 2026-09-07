public class Task13 {
}

abstract class PaymentProcess{
    public abstract void makePayment(double amount);
}


class CreditCardPayment extends PaymentProcess{
    private double balance;
    private String processor;

    public CreditCardPayment(String processor){
        this.processor = processor;
    }

    public double currentBalance(){
        return this.balance;
    }

    @Override
    public void makePayment(double amount){
        System.out.println("Payment of $" + amount + " processed");
        this.balance += amount;
    }
}

class MainRun13 {
    public static void main(String[] args) {
        CreditCardPayment payment = new CreditCardPayment("Stripe");

        System.out.println("Initial balance: " + payment.currentBalance()); // Expected: 0.0

        payment.makePayment(250.75); // Expected print: Payment of $250.75 processed.

        System.out.println("Updated balance: " + payment.currentBalance());
    }
}