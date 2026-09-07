import java.util.*;

class Task1 {
}

interface PhysicalActivity{
    String exercise();
}

interface FinancialActivity{
    void manageExpense(String date, double amount);
}

class Individual implements PhysicalActivity,FinancialActivity{
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

        for(double amount : expenses.get(date)){
            result += amount;
        }

        return Optional.of(result);
    }

}

class MainRun {
    public static void main(String[] args) {
        Individual individual = new Individual("Imran");

        // Test PhysicalActivity
        System.out.println("Activity: " + individual.exercise());

        // Test FinancialActivity (multiple expenses on a single day)
        individual.manageExpense("2026-06-05", 15.50);
        individual.manageExpense("2026-06-05", 24.50);
        individual.manageExpense("2026-06-06", 100.0);

        // Test getTotalExpense with Optional handling
        java.util.Optional<Double> totalDay1 = individual.getTotalExpense("2026-06-05");
        if (totalDay1.isPresent()) {
            System.out.println("Total expense on 2026-06-05: " + totalDay1.get()); // Expected: 40.0
        }

        java.util.Optional<Double> totalDay2 = individual.getTotalExpense("2026-06-06");
        System.out.println("Total expense on 2026-06-06: " + totalDay2.orElse(0.0)); // Expected: 100.0

        java.util.Optional<Double> totalDay3 = individual.getTotalExpense("2026-06-07");
        System.out.println("Expense on 2026-06-07 exists: " + totalDay3.isPresent()); // Expected: false
    }
}