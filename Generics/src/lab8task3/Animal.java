package lab8task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Animal{
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
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

    abstract void speak();
}

class Lion extends Animal implements Comparable<Lion>{
    public Lion(String name, int age){
        super(name,age);
    }

    @Override
    void speak(){
        System.out.println("Lion speaks!");
    }

    @Override
    public int compareTo(Lion other){
        return Integer.compare(this.getAge(), other.getAge());
    }

}

class Elephant extends Animal implements Comparable<Elephant>{
    public Elephant(String name, int age){
        super(name,age);
    }

    @Override
    void speak(){
        System.out.println("Elephant speaks!");
    }

    @Override
    public int compareTo(Elephant other){
        return Integer.compare(this.getAge(), other.getAge());
    }

}

class AnimalCage<T extends Animal & Comparable<T>>{
    private List<T> animals = new ArrayList<>();

    public void addAnimals(T animal){
        animals.add(animal);
    }

    public void sortAnimals(){
        Collections.sort(animals);
    }

    public void printAnimals(){
        for(T animal : animals){
            System.out.println("Name of this animal is: " + animal.getName() + " and its age is: " + animal.getAge());
            animal.speak();
        }
    }
}