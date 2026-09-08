import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Task1 {
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