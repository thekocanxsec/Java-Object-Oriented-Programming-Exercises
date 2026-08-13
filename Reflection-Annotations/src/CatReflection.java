import java.lang.reflect.Method;
import java.sql.SQLOutput;

@VeryImportant
public class CatReflection {
    private String name;
    private int age;

    public CatReflection(String name,int age){
        this.name = name;
        this.age = age;
    }
    //@Target(ElementType.TYPE) - ne moze radit jer smo postavili u anotaciji da ide na klase, ne na metode
    public CatReflection(String name){
        this.name = name;
    }

    public void meow(){
        System.out.println("Meow");
    }

    public void eat(){
        System.out.println("Cat eats");
    }



}

class MainRun2{
    static void main() {
        @SuppressWarnings("unused")
        CatReflection myCat = new CatReflection("Rocky");

        for(Method method : myCat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                try{
                    method.invoke(myCat);
                }
                catch(Exception e){
                    throw new RuntimeException(e);
                }
            }

        }

    }

}