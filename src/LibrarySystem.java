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
    public boolean checkoutBook(String isbn) {
        Book book = books.get(isbn);

        if (book == null) {
            System.out.println("Book not found in library system.");
            return false;
        }

        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            System.out.println("Checked out: " + book.getTitle());
            return true;
        } else {
            System.out.println("Book is out of stock.");
            return false;
        }
    }

    public boolean returnBook(String isbn) {
        Book book = books.get(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        book.setQuantity(book.getQuantity() + 1);
        System.out.println("Returned: " + book.getTitle());
        return true;
    }
}
