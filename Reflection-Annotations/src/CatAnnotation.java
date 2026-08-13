import java.lang.reflect.Method;

@VeryImportant
public class CatAnnotation {
    private String name;
    private int age;

    public CatAnnotation(String name,int age){
        this.name = name;
        this.age = age;
    }
    //@Target(ElementType.TYPE) - ne moze radit jer smo postavili u anotaciji da ide na klase, ne na metode
    public CatAnnotation(String name){
        this.name = name;
    }

    public void meow(){
        System.out.println("Meow");
    }

    public void eat(){
        System.out.println("Cat eats");
    }



}

class MainRun3{
    static void main() {
        @SuppressWarnings("unused")
        CatReflection myCat = new CatReflection("Rocky");

        if(myCat.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("This object is very important! ");
        }
        else{
            System.out.println("This object is not very important! ");
        }

    }

}

