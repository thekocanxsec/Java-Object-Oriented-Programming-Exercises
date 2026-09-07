import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Task10 {
}


interface Breathable{
    String breath();
}

interface Payment1{
    void makePayment (String date, double amount);
}

class Human implements Breathable,Payment1{
    private String fullName;
    private HashMap<String, List<Double>> payments;

    public Human(String fullName){
        this.fullName = fullName;
        this.payments = new HashMap<>();
    }

    @Override
    public String breath(){
        return "Breathing";
    }

    @Override
    public void makePayment(String date, double amount){
        if(!payments.containsKey(date)){
            payments.put(date, new ArrayList<>());
        }
        payments.get(date).add(amount);

    }

    public double getPayment(String date){
        if(!payments.containsKey(date)){
            return 0.0;
        }

        double result = 0.0;

        for(double amount : payments.get(date)){
            result += amount;
        }

        return result;
    }
}

class MainRun10{
    public static void main(String[] args) {
        Human human = new Human("Imran Kocan");

        // Test breath method
        System.out.println("Action: " + human.breath());

        // Test makePayment (handling multiple payments on the same day)
        human.makePayment("2026-09-06", 150.0);
        human.makePayment("2026-09-06", 50.0);
        human.makePayment("2026-09-07", 300.0);

        // Test getPayment for a day with multiple payments
        double totalDay1 = human.getPayment("2026-09-06");
        System.out.println("Total payment on 2026-09-06: " + totalDay1); // Expected: 200.0

        // Test getPayment for a day with a single payment
        double totalDay2 = human.getPayment("2026-09-07");
        System.out.println("Total payment on 2026-09-07: " + totalDay2); // Expected: 300.0
    }
}