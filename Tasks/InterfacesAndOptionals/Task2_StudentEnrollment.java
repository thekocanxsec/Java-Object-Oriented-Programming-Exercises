package InterfacesAndOptionals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

class Task2_StudentEnrollment {
}

interface Enrollable{
    void enroll();
}

interface Payment{
    void makePayment(String date, double amount);
}

class Student implements Enrollable, Payment{
    private String name;
    private HashMap<String, List<Double>> payments;

    public Student(String name){
        this.name = name;
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

    public Optional<Double> getPayment(String date){
        if(!payments.containsKey(date)){
            return Optional.empty();
        }

        double result = 0.0;

        for(Double amount : payments.get(date)){
            result += amount;
        }

        return Optional.of(result);
    }
}




class MainRun2 {
    public static void main(String[] args) {
        Student person = new Student("Imran");

        person.enroll();

        person.makePayment("2026-08-31", 15.50);
        person.makePayment("2026-08-31", 24.50);
        person.makePayment("2026-09-01", 100.00);

        String date1 = "2026-08-31";
        person.getPayment(date1).ifPresentOrElse(
                total -> System.out.println("Total expenses for " + date1 + ": " + total),
                () -> System.out.println("No expenses for " + date1)
        );

        String date2 = "2026-09-01";
        System.out.println("Total expenses for " + date2 + ": " + person.getPayment(date2).orElse(0.0));

        String date3 = "2025-01-01";
        if (person.getPayment(date3).isEmpty()) {
            System.out.println("No recorded expenses for " + date3);
        }
    }
}