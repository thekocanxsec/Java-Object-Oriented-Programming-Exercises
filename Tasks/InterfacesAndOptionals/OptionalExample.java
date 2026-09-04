package InterfacesAndOptionals;

import java.util.Optional;

class OptionalExample {
}

class MainRun4{
    record Wolf(String name, int age) {}

    public static Optional<Wolf> getWolfByNameOptional(String name) {
        return Optional.empty();
    }

    static void main(String[] args) {

        Wolf wolf = new Wolf("Strasni", 23);

        Optional<Wolf> wolfOptional = getWolfByNameOptional("Strasni");
        if (wolfOptional.isPresent()) {
            System.out.println("Wolf age: " + wolfOptional.get().age());
        } else {
            System.out.println("No wolf found");
        }

    }
}