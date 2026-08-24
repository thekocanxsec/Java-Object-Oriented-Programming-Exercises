interface OrderState {
    void nextStep(OrderContext order);
    void cancelOrder(OrderContext order);
}

class NewOrderState implements OrderState{
    @Override
    public void nextStep(OrderContext order){
        System.out.println("Order is confirmed and paid! Moving to Paid state...");
        order.setState(new PaidOrderState());
    }

    @Override
    public void cancelOrder(OrderContext order){
        System.out.println("Order cancelled successfully.");
    }
}

class PaidOrderState implements OrderState{
    @Override
    public void nextStep(OrderContext order){
        System.out.println("Order is packed and shipped to customer! Moving to Shipped state...");
        order.setState(new ShippedOrderState());
    }

    @Override
    public void cancelOrder(OrderContext order){
        System.out.println("Order cancelled. Issuing a refund to the customer.");
    }
}

class ShippedOrderState implements OrderState{
    @Override
    public void nextStep(OrderContext order){
        System.out.println("Order is already delivered. No more steps!");
    }

    @Override
    public void cancelOrder(OrderContext order){
        System.out.println("Cannot cancel! Order has already been shipped.");
    }
}

class OrderContext{
    private OrderState currentState;

    public OrderContext(){
        this.currentState = new NewOrderState();
    }

    public void setState(OrderState state){
        this.currentState = state;
    }

    public void proceedNext(){
        currentState.nextStep(this);
    }

    public void cancel(){
        currentState.cancelOrder(this);
    }

}

class MainOrderTest{
    static void main() {
        OrderContext order1 = new OrderContext();

        order1.proceedNext();
        order1.proceedNext();
        order1.cancel();
    }
}