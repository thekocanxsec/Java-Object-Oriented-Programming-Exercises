import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

class Dog {
    private final String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void bark() {
        System.out.println("Woof!");
    }

    public void say(String message) {
        System.out.println("Dog says: " + message);
    }

    private void whisper() {
        System.out.println("Secret bark...");
    }

    public static void info() {
        System.out.println("Static info about dogs.");
    }
}

class MainReflection {
    public static void main(String[] args) {
        try {
            Dog myDog = new Dog("Bobi", 3);
            Class<?> clazz = myDog.getClass();

            System.out.println("=== 1. Klasa ===");
            System.out.println("Full Class Name: " + clazz.getName());
            System.out.println();

            System.out.println("=== 2. Polja klase ===");
            for (Field field : clazz.getDeclaredFields()) {
                String accessLevel = Modifier.toString(field.getModifiers());
                System.out.println("Name: " + field.getName() +
                        " | Type: " + field.getType().getSimpleName() +
                        " | Access: " + accessLevel);
            }
            System.out.println();

            System.out.println("=== 3. Metode klase ===");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("Name: " + method.getName() +
                        " | Return Type: " + method.getReturnType().getSimpleName() +
                        " | Parameters: " + Arrays.toString(method.getParameterTypes()));
            }
            System.out.println();

            System.out.println("=== 4. Izmjena private final polja (name) ===");
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);

            System.out.println("Stara vrijednost name: " + nameField.get(myDog));
            nameField.set(myDog, "Rex");
            System.out.println("Nova vrijednost name: " + nameField.get(myDog));
            System.out.println();

            System.out.println("=== 5. Izmjena polja age ===");
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println("Stara vrijednost age: " + ageField.get(myDog));
            ageField.setInt(myDog, 5);
            System.out.println("Nova vrijednost age: " + ageField.get(myDog));
            System.out.println();

            System.out.println("=== 6. Pozivanje metoda ===");

            Method barkMethod = clazz.getDeclaredMethod("bark");
            barkMethod.setAccessible(true);
            System.out.print("Poziv bark(): ");
            barkMethod.invoke(myDog);

            Method sayMethod = clazz.getDeclaredMethod("say", String.class);
            sayMethod.setAccessible(true);
            System.out.print("Poziv say(): ");
            sayMethod.invoke(myDog, "Refleksija je mocna!");

            Method whisperMethod = clazz.getDeclaredMethod("whisper");
            whisperMethod.setAccessible(true);
            System.out.print("Poziv private whisper(): ");
            whisperMethod.invoke(myDog);

            Method infoMethod = clazz.getDeclaredMethod("info");
            infoMethod.setAccessible(true);
            System.out.print("Poziv static info(): ");
            infoMethod.invoke(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}