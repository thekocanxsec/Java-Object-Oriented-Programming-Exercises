import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task4 {
}

enum Gender{
    MALE,FEMALE
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

class Assistant extends Person{
    public Assistant(String firstName, int age, Gender gender){
        super(firstName, age,gender);
    }

}

class Professor extends Person{
    public Professor(String firstName, int age, Gender gender){
        super(firstName, age,gender);
    }
}

class Company<T extends Person>{
    private List<T> employees;

    public Company(List<T> employees){
        this.employees = employees;
    }

    public List<T> getEmployees(){
        return this.employees;
    }

    public void setEmployees(List<T> employees){
        this.employees = employees;
    }

    public Optional<List<T>> filterByGender(Gender gender){
        List<T> filteredList = new ArrayList<>();

        for(T person : employees){
            if(person.getGender() == gender){
                filteredList.add(person);
            }
        }
        return filteredList.isEmpty() ? Optional.empty() : Optional.of(filteredList);
    }

    public Optional<T> getByFirstName(String firstName){
        for(T person : employees){
            if(person.getFirstName().equals(firstName)){
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }
}