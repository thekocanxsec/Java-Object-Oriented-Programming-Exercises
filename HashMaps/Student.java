import java.util.Collections;
import java.util.HashMap;

public class Student{
    private String indexNumber;
    private String fullName;
    private double gpa;

    public Student(String indexNumber, String fullName, double gpa){
        this.indexNumber = indexNumber;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public String getIndexNumber(){
        return this.indexNumber;
    }


    public double getGpa(){
        return this.gpa;
    }




}

class Main2{
    static void main() {
        HashMap<String, Student> students = new HashMap<>();
        Student student1 = new Student("01", "Imran Kocan", 3.0);
        Student student2 = new Student("02", "Tarik Hamzic", 3.4);
        Student student3 = new Student("03", "Muhamad Assaad", 3.6);

        students.put(student1.getIndexNumber(),student1);
        students.put(student2.getIndexNumber(),student2);
        students.put(student3.getIndexNumber(),student3);


        // ne znam kako da povratim ove podatke koje trazis zaboravio sam
        Student searchStudent = students.get("02");

        System.out.println("Name: " + searchStudent.getIndexNumber() + " his gpa " + searchStudent.getGpa());

    }
}



