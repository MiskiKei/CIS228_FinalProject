import java.util.HashMap;

public class LibrarySystem {

    private HashMap<String, Book> books;

    public LibrarySystem() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public Book searchByISBN(String isbn) {
        return books.get(isbn);
    }

    public Book searchByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void updateQuantity(String isbn, int quantity) {
        Book book = books.get(isbn);
        if (book != null) {
            book.setQuantity(quantity);
        }
    }

    public void displayAllBooks() {
        for (Book book : books.values()) {
            System.out.println(
                "Title: " + book.getTitle() +
                ", Author: " + book.getAuthor() +
                ", ISBN: " + book.getISBN() +
                ", Quantity: " + book.getQuantity()
            );
        }
    }
}
