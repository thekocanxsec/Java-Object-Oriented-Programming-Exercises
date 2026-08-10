import java.util.HashMap;

public class Predefined {
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

class Book {
    private String name;
    private String contents;
    private int publishingYear;

    public Book(String name, int publishingYear, String contents) {
        this.name = name;
        this.publishingYear = publishingYear;
        this.contents = contents;
    }
    public Book(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishingYear() {
        return this.publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return "Name: " + this.name + " (" + this.publishingYear + ")\n" + "Contents: " + this.contents +"\n";
    }
}

class RunBookStore {
    public static void main(String[] args) {
        Book book1 = new Book("Dervis i Smrt", 1811, "Dervis umire");
        Book book2 = new Book("Bijeli Cigani", 1813, "Romi sviraju");

        HashMap<String, Book> bookCollection = new HashMap<String, Book>();
        bookCollection.put(book1.getName(), book1);
        bookCollection.put(book2.getName(), book2);

        Book trazena = bookCollection.get("Dervis i Smrt");

        System.out.println(trazena.getPublishingYear());
        System.out.println(trazena.getContents());


    }
}




