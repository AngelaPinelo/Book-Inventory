import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Book Inventory Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Books");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(title, author, ISBN, genre, price, quantity);
                    if (inventory.addBook(book)) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Book with the same ISBN already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    ISBN = scanner.nextLine();
                    if (inventory.removeBook(ISBN)) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN of the book to update: ");
                    ISBN = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter new genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    price = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine();

                    Book updatedBook = inventory.updateBook(ISBN, title, author, genre, price, quantity);
                    if (updatedBook != null) {
                        System.out.println("Book updated successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter keyword to search (title, author, genre, or ISBN): ");
                    String keyword = scanner.nextLine();
                    List<Book> searchResults = inventory.searchBooks(keyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book resultBook : searchResults) {
                            System.out.println(resultBook);
                        }
                    }
                    break;

                case 5:
                    inventory.displayBooks();
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
