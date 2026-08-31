package InterfacesAndOptionals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Task1_ActivityManagmentSystem {
}

interface PhysicalActivity{
    String exercise();
}

interface FinancialActivity{
    void manageExpense(String date, double amount);
}

class Individual implements PhysicalActivity, FinancialActivity{
    private String name;
    private HashMap<String, List<Double>> expenses;

    public Individual(String name){
        this.name = name;
        this.expenses = new HashMap<>();
    }

    @Override
    public String exercise(){
        return "Exercising";
    }

    @Override
    public void manageExpense(String date, double amount){
        if(!expenses.containsKey(date)){
            expenses.put(date, new ArrayList<>());
        }
        expenses.get(date).add(amount);
    }

    public Optional<Double> getTotalExpense(String date){
        if(!expenses.containsKey(date)){
            return Optional.empty();
        }

        double result = 0.0;

        for(Double amount : expenses.get(date)){
            result += amount;
        }

        return Optional.of(result);
    }
}

class MainRun {
    public static void main(String[] args) {
        Individual person = new Individual("Imran");

        System.out.println("Activity: " + person.exercise());

        person.manageExpense("2026-08-31", 15.50);
        person.manageExpense("2026-08-31", 24.50);
        person.manageExpense("2026-09-01", 100.00);

        String date1 = "2026-08-31";
        person.getTotalExpense(date1).ifPresentOrElse(
                total -> System.out.println("Total expenses for " + date1 + ": " + total),
                () -> System.out.println("No expenses for " + date1)
        );

        String date2 = "2026-09-01";
        System.out.println("Total expenses for " + date2 + ": " + person.getTotalExpense(date2).orElse(0.0));

        String date3 = "2025-01-01";
        if (person.getTotalExpense(date3).isEmpty()) {
            System.out.println("No recorded expenses for " + date3);
        }
    }
}


