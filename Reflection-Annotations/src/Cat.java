import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(){
        this.age = age;
    }

    public static void thisIsPublicStaticMethod() {
        System.out.println("I'm public and static");
    }

    public void meow() {
        System.out.println("meow");
    }

    public void saySomething(String something){
        System.out.println("I said something ".concat(something));
    }

    //we are going to set this one private
    private void heyThisIsPrivate() {
        System.out.println("How did you call this?");
    }



}

class MainRun{
    static void main() {
        Cat myCat = new Cat("Cicko",12);

        Method[] catMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : catMethods) {
            System.out.println("Processing method: " + method.getName());

            try {
                if (method.getName().equals("meow") && method.getParameterCount() == 0) {
                    method.invoke(myCat); // Pozivanje bez parametara

                } else if (method.getName().equals("saySomething") && method.getParameterCount() == 1) {
                    method.invoke(myCat, "AW AW AW"); // Prosjeđivanje parametra

                } else if (method.getName().equals("heyThisIsPrivate")) {
                    method.setAccessible(true); // Mora se uključiti prije invoke()
                    method.invoke(myCat);

                } else if (method.getName().equals("thisIsPublicStaticMethod")) {
                    // Za statičke metode objekat nije potreban, prosljeđuje se null
                    method.invoke(null);
                }

            } catch (IllegalAccessException e) {
                System.err.println("Pristup metodi " + method.getName() + " je odbijen: " + e.getMessage());
            } catch (InvocationTargetException e) {
                // Izuzetak koji je bacila sama metoda unutar sebe
                System.err.println("Metoda je bacila izuzetak: " + e.getTargetException().getMessage());
            }
    }
}}

