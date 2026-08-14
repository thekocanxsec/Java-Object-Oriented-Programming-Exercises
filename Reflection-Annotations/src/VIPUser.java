import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VIPUser {
}

@VIPUser
class User{
    private String username;
    private int id;


    public User(String username, int id){
        this.username=username;
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}

class RegularUser{
    private String username;
    private int id;

    public RegularUser(String username, int id){
        this.username=username;
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

class MainRun5{
    static void main() {
        User vipUser = new User("Imran", 20);
        RegularUser regularUser = new RegularUser("Tarik",21);

        if(vipUser.getClass().isAnnotationPresent(VIPUser.class)){
            System.out.println("This user is vip user");
        }
        else{
            System.out.println("User is not vip");
        }


        if(regularUser.getClass().isAnnotationPresent(VIPUser.class)){
            System.out.println("Regular user is VIP.");
        } else {
            System.out.println("Regular user is NOT a VIP.");
        }

    }
}