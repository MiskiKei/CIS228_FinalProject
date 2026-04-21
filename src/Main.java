import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        library.loadCSV("src/Books.csv");

        while (true) {
            System.out.println("\n._._Library Menu_._.");
            System.out.println("1. Display all books");
            System.out.println("2. Add book");
            System.out.println("3. Delete book");
            System.out.println("4. Update book quantity");
            System.out.println("5. Search by ISBN");
            System.out.println("6. Checkout book");
            System.out.println("7. Return book");
            System.out.println("8. Quit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 8) break;

            switch (choice) {

                case 1:
                    library.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    library.addBook(new Book(title, author, isbn, qty));
                    break;

                case 3:
                    System.out.print("ISBN to delete: ");
                    library.removeBook(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("ISBN: ");
                    String upIsbn = scanner.nextLine();

                    System.out.print("New quantity: ");
                    int newQty = scanner.nextInt();
                    scanner.nextLine();

                    library.updateQuantity(upIsbn, newQty);
                    break;

                case 5:
                    System.out.print("ISBN: ");
                    Book found = library.searchByISBN(scanner.nextLine());

                    if (found != null) {
                        System.out.println(found.getTitle() + " by " + found.getAuthor());
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 6:
                    System.out.print("ISBN to checkout: ");
                    library.checkoutBook(scanner.nextLine());
                    break;

                case 7:
                    System.out.print("ISBN to return: ");
                    library.returnBook(scanner.nextLine());
                    break;
            }
        }

        scanner.close();
        System.out.println("Goodbye! Thank you for using the program.");
    }
}