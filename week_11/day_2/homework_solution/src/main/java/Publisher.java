import java.util.ArrayList;

public class Publisher {

    private String name;
    private ArrayList<Book> stock;

    public Publisher(String name){
        this.name = name;
        this.stock = new ArrayList<>();
    }

    public int getStockCount(){
        return this.stock.size();
    }

    public void adBookToStock(Book book){
        this.stock.add(book);
    }

    public Book getBook(){
        return stock.remove(0);
    }

}
