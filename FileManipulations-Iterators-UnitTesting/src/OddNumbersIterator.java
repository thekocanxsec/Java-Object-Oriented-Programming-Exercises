import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddNumbersIterator implements Iterator<Integer> {
    private int[] elements;
    private int currentIndex = 0;

    public OddNumbersIterator(int[] elements){
        this.elements = elements;
    }

    @Override
    public boolean hasNext(){
        while(currentIndex < elements.length && elements[currentIndex] % 2 == 0){
            currentIndex++;
        }
        return currentIndex < elements.length;
    }

    @Override
    public Integer next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return elements[currentIndex++];
    }
}

class MainRun{
    static void main() {
        int[] numbers = {1,2,3,4,5};

        OddNumbersIterator oddNumbersIterator = new OddNumbersIterator(numbers);

        while(oddNumbersIterator.hasNext()){
            int result = oddNumbersIterator.next();
            System.out.println(result);
        }
    }
}
