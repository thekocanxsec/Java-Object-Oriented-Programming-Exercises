import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Task12 {
}

enum DegreeLevel{
    BACHELOR,MASTER
}

class Person2{
    private String name;
    private int age;
    private DegreeLevel degree;

    public Person2(String name, int age, DegreeLevel degree){
        this.name = name;
        this.age = age;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DegreeLevel getDegree() {
        return degree;
    }

    public void setDegree(DegreeLevel degree) {
        this.degree = degree;
    }
}

class UndergraduateStudent extends Person2{
    public UndergraduateStudent(String name, int age, DegreeLevel degree){
        super(name,age,degree);
    }
}

class GraduateStudent extends Person2{
    public GraduateStudent(String name, int age, DegreeLevel degree){
        super(name,age,degree);
    }
}

class University<T extends Person2>{
    private List<T> students;

    public University(List<T> students){
        this.students = students;
    }

    public void setStudents(List<T> students){
        this.students = students;
    }

    public List<T> getStudents(){
        return this.students;
    }

    public Optional<List<T>> filterByDegree(DegreeLevel level){
        List<T> list = new ArrayList<>();

        for(T people : students){
            if(people.getDegree() == level){
                list.add(people);
            }
        }

        return list.isEmpty() ? Optional.empty() : Optional.of(list);
    }

    public Optional<T> getStudentByName(String name){
        for(T person : students){
            if(person.getName().equals(name)){
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }
}



class MainRun12 {
    public static void main(String[] args) {
        List<Person2> studentList = new ArrayList<>();
        studentList.add(new UndergraduateStudent("Emir", 21, DegreeLevel.BACHELOR));
        studentList.add(new GraduateStudent("Amina", 24, DegreeLevel.MASTER));
        studentList.add(new UndergraduateStudent("Tarik", 22, DegreeLevel.BACHELOR));

        University<Person2> university = new University<>(studentList);

        // Test getStudentByName with Optional
        Optional<Person2> found = university.getStudentByName("Amina");
        System.out.println("Found student: " + (found.isPresent() ? found.get().getName() : "Not found"));

        // Test filterByDegree with Optional<List<T>>
        Optional<List<Person2>> bachelors = university.filterByDegree(DegreeLevel.BACHELOR);
        if (bachelors.isPresent()) {
            System.out.println("Bachelor students count: " + bachelors.get().size());
        }
    }
}
