import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Task7 {
}

enum Gender1{
    MALE,FEMALE
}

class Person1{

    private String firstName;
    private int age;
    private Gender gender;

    public Person1 (String firstName, int age, Gender gender){
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


class Assistant1 extends Person1{
    public Assistant1 (String firstName, int age, Gender gender){
        super(firstName,age,gender);
    }
}

class Professor1 extends Person1{
    public Professor1 (String firstName, int age, Gender gender){
        super(firstName,age,gender);
    }
}

class Company1<T extends Person1>{
    private List<T> employees;

    public Company1(List<T> employees){
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

        for(T people : employees){
            if(people.getGender() == gender){
                filteredList.add(people);
            }
        }
        return filteredList.isEmpty() ? Optional.empty() : Optional.of(filteredList);
    }

    public Optional<T> getByFirstName(String firstName){
        for(T people : employees){
            if(people.getFirstName().equals(firstName)){
                return Optional.of(people);
            }
        }
        return Optional.empty();
    }

}


class MainRun7{
    public static void main(String[] args) {
        List<Person1> staff = new ArrayList<>();
        staff.add(new Professor1("Amina", 40, Gender.FEMALE));
        staff.add(new Assistant1("Emir", 27, Gender.MALE));

        Company1<Person1> company = new Company1<>(staff);

        // Test getByFirstName with Optional
        Optional<Person1> found = company.getByFirstName("Emir");
        System.out.println("Found by name: " + (found.isPresent() ? found.get().getFirstName() : "Not found"));

        // Test filterByGender with Optional<List<T>>
        Optional<List<Person1>> females = company.filterByGender(Gender.FEMALE);
        if (females.isPresent()) {
            System.out.println("Females count: " + females.get().size());
        }
    }
}