package InterfacesAndOptionals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3_Employee {
}


interface Assignable{
    void assignProject(String projectName);
}

interface Workable{
    void logWorkHours(String date, double hours);
}

class Employee implements Assignable, Workable{
    private Map<String, List<Double>> workHours = new HashMap<>();


    @Override
    public void assignProject(String projectName){
        System.out.println("Employee assigned to project " + projectName);
    }

    @Override
    public void logWorkHours(String date, double hours){
        if(!workHours.containsKey(date)){
            workHours.put(date, new ArrayList<>());
        }

        workHours.get(date).add(hours);
    }

    public double getTotalHours(String date){
        if(!workHours.containsKey(date)){
            return 0.0;
        }
        double result = 0.0;

        for(double amount : workHours.get(date)){
            result += amount;
        }
        return result;
    }

}

class MainRun3 {
    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.assignProject("Cybersecurity Audit");

        employee.logWorkHours("2026-08-31", 4.5);
        employee.logWorkHours("2026-08-31", 3.5);
        employee.logWorkHours("2026-09-01", 10.0);

        System.out.println("Total hours for 2026-08-31: " + employee.getTotalHours("2026-08-31"));
        System.out.println("Total hours for 2026-09-01: " + employee.getTotalHours("2026-09-01"));
        System.out.println("Total hours for 2025-01-01: " + employee.getTotalHours("2025-01-01"));
    }
}
