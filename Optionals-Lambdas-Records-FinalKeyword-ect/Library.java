import java.util.HashMap;
import java.util.Optional;

class Library{
    private HashMap<String,Book> books = new HashMap<>();


    public void addBook(Book book){
        books.put(clean(book.title()), book);
    }

    public void removeBook(String input){
        books.remove(clean(input)); // brise kljuc pod ovim nazivom
    }

    public Optional<Book> findByExactTitle(String title){
        return Optional.ofNullable(books.get(clean(title)));
    }

    public Optional<Book> findByTitleStart(String prefix){
        String search = clean(prefix);

        for(Book book : books.values()){
            if(clean(book.title()).startsWith(search)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public String clean(String input){
        return input.trim().toLowerCase();
    }


}

record Book(String title,String author,int year){

}