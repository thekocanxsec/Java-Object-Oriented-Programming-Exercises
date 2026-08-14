import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecution {
}


class TaskRunner{
    @LogExecution
    public String taskOne(){
        return "This is first task!";
    }

    public String taskTwo(){
        return "This is second task!";
    }

    @LogExecution
    public String taskThree(){
        return "This is third task!";
    }
}

class MainRun6{
    static void main() {
        TaskRunner taskRunner = new TaskRunner();

        for(Method method : taskRunner.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(LogExecution.class)){
                try{
                    System.out.println(method.invoke(taskRunner));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}