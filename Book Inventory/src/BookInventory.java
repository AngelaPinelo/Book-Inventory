import java.util.*;

public class BookInventory {
    private Map<String, Book> books;

    public BookInventory() {
        books = new HashMap<>();
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getISBN())) {
            return false;
        }
        books.put(book.getISBN(), book);
        return true;
    }

    public boolean removeBook(String ISBN) {
        return books.remove(ISBN) != null;
    }

    public Book updateBook(String ISBN, String title, String author, String genre, double price, int quantity) {
        Book book = books.get(ISBN);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setPrice(price);
            book.setQuantity(quantity);
        }
        return book;
    }

    public Book getBook(String ISBN) {
        return books.get(ISBN);
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getGenre().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getISBN().equalsIgnoreCase(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    public void displayBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}
