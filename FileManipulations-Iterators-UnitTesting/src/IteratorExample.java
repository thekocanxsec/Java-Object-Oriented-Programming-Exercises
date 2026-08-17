import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(4);
        numbers.add(1);

        Iterator<Integer> iterator = numbers.iterator();

        while(iterator.hasNext()){
            Integer tempInt = iterator.next();
            System.out.println(tempInt);
        }
    }
}
