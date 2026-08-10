import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> numbers = new HashMap<String, String>();
        numbers.put("One", "Yksi");
        numbers.put("Two", "Kaksi");

        String translation = numbers.get("One");
        System.out.println(translation);

        System.out.println(numbers.get("Two"));
        System.out.println(numbers.get("Three"));
        System.out.println(numbers.get("Yksi"));
    }
}
