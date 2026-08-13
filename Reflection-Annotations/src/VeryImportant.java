import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ukoliko zelimo da ide na vise elemenata kao na primjer da se anotacija moze primjeniti i na klasi i na metodi
//@Target({ElementType.TYPE, ElementType.METHOD})

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VeryImportant {

}
