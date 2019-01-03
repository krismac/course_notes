import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private String name;
    private int capacity;
    private ArrayList<Book> books;
    private HashMap<String, Integer> genreCounts;

    public Library(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.books = new ArrayList<>();
        this.genreCounts = new HashMap<>();
    }

    public int getBookCount(){
        return this.books.size();
    }

    public void addBook(Book book){
        if (!isFull()){
            this.books.add(book);
            incrementGenreCount(book.getGenre());
        }
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

    public void buyFromPublisher(Publisher publisher){
        if (!isFull()){
            Book book = publisher.getBook();
            addBook(book);
        }
    }

    public boolean isFull(){
        return books.size() >= this.capacity;
    }

    public HashMap<String, Integer> getGenreMap(){
        return this.genreCounts;
    }

    public void incrementGenreCount(String genre){
        Integer genreCount = genreCounts.get(genre);
        if (genreCount == null){
            genreCount = 0;
        }
        genreCounts.put(genre, genreCount + 1);
    }
}
