import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MenuCategory{
    String name();
    boolean available() default true ;
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface OrderAction{
    String handledBy();
    int estimatedMinutes() default 5;
    boolean requiresPayment() default false;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldValidation{
    int maxLength() default 50;
    boolean nullable() default false;
}

@MenuCategory(name = "Pizza", available = true)
class PizzaOrder{
    @FieldValidation(maxLength = 30, nullable = false)
    public String customerName;

    @FieldValidation(maxLength = 100, nullable = true)
    public String specialRequest;

    @FieldValidation(maxLength = 20,nullable = false)
    public String itemName;

    @OrderAction(handledBy = "Cashier", estimatedMinutes = 2, requiresPayment = false)
    public void takeOrder(){
        System.out.println("Taking the order...");
    }

    @OrderAction(handledBy = "Chef", estimatedMinutes = 15)
    public void prepareOrder(){
        System.out.println("Preparing pizza...");
    }

    @OrderAction(handledBy = "Cashier", requiresPayment = true)
    public void processPayment(){
        System.out.println("Processing payment...");
    }
}

class MainRun9 {
    public static void main(String[] args) {
        PizzaOrder order = new PizzaOrder();
        Class<?> clazz = order.getClass();

        if(order.getClass().isAnnotationPresent(MenuCategory.class)){
            MenuCategory menuCat = order.getClass().getAnnotation(MenuCategory.class);
            System.out.println("=== Menu Category ===");
            System.out.println("Category : " + menuCat.name());
            System.out.println("Available: " + (menuCat.available() ? "Yes" : "No"));
            System.out.println();
        }

        for(Method method : order.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(OrderAction.class)){
                OrderAction oAction = method.getAnnotation(OrderAction.class);
                System.out.println("Method          : " + method.getName());
                System.out.println("Handled By      : " + oAction.handledBy());
                System.out.println("Est. Time       : " + oAction.estimatedMinutes() + " min(s)");
                System.out.println("Requires Payment: " + (oAction.requiresPayment() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }
}