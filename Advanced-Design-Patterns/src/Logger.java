import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;


class Logger {
    private static Logger instance;

    private Logger(){}

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public String log(String message){
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return "[" + timestamp + "] " + message;
    }


}



class MainRun3{
    static void main() {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        System.out.println("Is log1 and log2 same? " + (log1 == log2));


        System.out.println(log1.log("Hello, this is first message!"));
        System.out.println(log2.log("Hello, this is second message!"));

    }
}
