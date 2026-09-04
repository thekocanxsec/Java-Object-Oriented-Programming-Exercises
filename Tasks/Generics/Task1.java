package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task1 {
}

enum Gender{
    MALE, FEMALE
}

class Person{
    private String firstName;
    private int age;
    private Gender gender;

    public Person(String firstName, int age, Gender gender){
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public int getAge(){
        return this.age;
    }

    public Gender getGender(){
        return this.gender;
    }

}

class Assistant extends Person{
    public Assistant(String firstName, int age, Gender gender){
        super(firstName,age,gender);
    }
}

class Professor extends Person{
    public Professor(String firstName, int age, Gender gender){
        super(firstName,age,gender);
    }
}

class Company<T extends Person>{
    private List<T> employees;

    public Company(List<T> employees){
        this.employees = employees;
    }

    public void setEmployees(List<T> employees){
        this.employees = employees;
    }

    public List<T> getEmployees(){
        return this.employees;
    }

    public Optional<List<T>> filterByGender(Gender gender){
        List<T> filteredList = new ArrayList<>();

        for(T employee : employees){
            if(employee.getGender() == gender){
                filteredList.add(employee);
            }
        }
        return filteredList.isEmpty() ? Optional.empty() : Optional.of(filteredList);
    }

    public Optional<T> getByFirstName(String firstName){
        for(T employee : employees){
            if(employee.getFirstName() == firstName){
                return Optional.of(employee);
            }

        }
        return Optional.empty();
    }
}

class MainRun {
    public static void main(String[] args) {
        List<Person> staff = new ArrayList<>();
        staff.add(new Assistant("Emir", 25, Gender.MALE));
        staff.add(new Professor("Lejla", 42, Gender.FEMALE));
        staff.add(new Assistant("Tarik", 28, Gender.MALE));

        Company<Person> company = new Company<>(staff);

        System.out.println("--- Testing getByFirstName ---");
        Optional<Person> found = company.getByFirstName("Lejla");
        if (found.isPresent()) {
            System.out.println("Found: " + found.get().getFirstName() + " (Age: " + found.get().getAge() + ")");
        } else {
            System.out.println("Not found");
        }

        System.out.println("\n--- Testing filterByGender (MALE) ---");
        Optional<List<Person>> males = company.filterByGender(Gender.MALE);
        if (males.isPresent()) {
            for (Person p : males.get()) {
                System.out.println("Male employee: " + p.getFirstName());
            }
        }
    }
}