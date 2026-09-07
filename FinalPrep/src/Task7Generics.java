import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal implements Comparable<Animal> {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void speak();

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.age, other.age);
    }
}

class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Roar!");
    }
}

class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Trumpet!");
    }
}

class AnimalCage<T extends Animal & Comparable<T>> {
    private List<T> animals = new ArrayList<>();

    public void addAnimal(T animal) {
        animals.add(animal);
    }

    public void sortAnimals() {
        Collections.sort(animals);
    }

    public void printAnimals() {
        for (T animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge());
            animal.speak();
        }
    }
}
