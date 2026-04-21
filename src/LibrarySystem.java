import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    void loadCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] section = line.split(", ");

                String title = section[0];
                String author = section[1];
                String isbn = section[2];
                int quantity = Integer.parseInt(section[3]);

                addBook(new Book(title, author, isbn, quantity));
            }

        } catch (IOException e) {
            System.out.println("Error loading CSV file.");
        }
    }
}
