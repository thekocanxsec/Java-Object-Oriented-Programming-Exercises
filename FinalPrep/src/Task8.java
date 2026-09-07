import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

class Task8 {
}


interface Enrollable{
    void enroll();
}

interface Payment{
    void makePayment(String date, double amount);
}

class Student implements Enrollable,Payment{
    private HashMap<String, List<Double>> payments;

    public Student(){
        this.payments = new HashMap<>();
    }

    @Override
    public void enroll(){
        System.out.println("Enrolled in a course");
    }

    @Override
    public void makePayment(String date, double amount){
        if(!payments.containsKey(date)){
            payments.put(date, new ArrayList<>());
        }
        payments.get(date).add(amount);
    }

    public double getPayment (String date){
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

class MainRun8 {
    public static void main(String[] args) {
        Student student = new Student();

        // Test Enrollable interface
        student.enroll(); // Expected: Enrolled in a course

        // Test Payment interface (handling multiple payments on a single day)
        student.makePayment("2026-09-06", 150.0);
        student.makePayment("2026-09-06", 50.0);
        student.makePayment("2026-09-07", 200.0);

        // Test getPayment for a day with multiple payments
        double totalDay1 = student.getPayment("2026-09-06");
        System.out.println("Total payment on 2026-09-06: " + totalDay1); // Expected: 200.0

        // Test getPayment for a day with a single payment
        double totalDay2 = student.getPayment("2026-09-07");
        System.out.println("Total payment on 2026-09-07: " + totalDay2); // Expected: 200.0

        // Test getPayment for a non-existent day
        double totalDay3 = student.getPayment("2026-09-08");
        System.out.println("Total payment on 2026-09-08: " + totalDay3); // Expected: 0.0 (or whatever default is handled)
    }
}