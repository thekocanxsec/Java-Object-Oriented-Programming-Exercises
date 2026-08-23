interface ModernPayment {
    void pay(double amount);
}

class OldStripePayment{
    public void makePayment(double totalAmount){
        System.out.println("Processing old payment system: $" + totalAmount);
    }
}

class StripePayment implements ModernPayment{
    private OldStripePayment oldStripePayment;

    public StripePayment(OldStripePayment oldStripePayment){
        this.oldStripePayment = oldStripePayment;
    }

    @Override
    public void pay(double amount){
        oldStripePayment.makePayment(amount);
    }
}

class MainRun13{
    static void main() {
        OldStripePayment oldPayment = new OldStripePayment();

        ModernPayment payment1 = new StripePayment(oldPayment);

        payment1.pay(150.00);

    }
}