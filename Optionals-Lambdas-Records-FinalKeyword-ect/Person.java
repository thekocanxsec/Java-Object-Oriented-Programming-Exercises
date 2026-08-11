import java.sql.SQLOutput;

record Person(String name, int age, int height){

    public static Person createAnonymus(){
        return new Person("Anonymus", 0, 0);
    }
}


class Main2{
    static void main() {
        Person p1 = new Person("John", 24,184);
        Person p2 = Person.createAnonymus();
        Person p3 = Person.createAnonymus();
        Person p4 = new Person("Abigail", 23, 160);
        Person p5 = new Person("John", 24,184);

        System.out.println(p1.equals(p5));
        System.out.println(p2.toString());
        System.out.println(p3.height());
        System.out.println(p4.age());

    }
}

