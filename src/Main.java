import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a Book entity
class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private String status;

    public Book(int id, String title, String author, String isbn, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getStatus() {
        return status;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> catalog = new ArrayList<>();
        int nextId = 1;

        while (true) {
            // Display Main Menu Header
            System.out.println("==================================================");
            System.out.println("               LIBRARY BOOK CATALOG               ");
            System.out.println("==================================================");
            System.out.println("[1] Add New Book");
            System.out.println("[2] View Book Catalog");
            System.out.println("[3] Exit System");
            System.out.println("==================================================");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number (1-3).\n");
                continue;
            }

            System.out.println(); // Spacing line

            if (choice == 1) {
                // Add New Book Section
                System.out.println("--- ADD NEW BOOK ---");
                System.out.print("Enter Title: ");
                String title = scanner.nextLine().trim();

                System.out.print("Enter Author: ");
                String author = scanner.nextLine().trim();

                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine().trim();

                System.out.print("Enter Status (AVAILABLE / BORROWED): ");
                String status = scanner.nextLine().trim();

                // Store new book in the catalog
                catalog.add(new Book(nextId++, title, author, isbn, status));

                System.out.println("\nSUCCESS: Book cataloged into database!\n");

            } else if (choice == 2) {
                // View Catalog Section
                System.out.println("==========================================================================");
                System.out.println("                           LIBRARY BOOK CATALOG                           ");
                System.out.println("==========================================================================");

                // Header Border
                System.out.println("+---+----------------------+--------------------+---------------+-----------+");
                System.out.printf("| %-1s | %-20s | %-18s | %-13s | %-9s |\n", "ID", "TITLE", "AUTHOR", "ISBN", "STATUS");
                System.out.println("+---+----------------------+--------------------+---------------+-----------+");

                // Display Catalog Entries
                for (Book book : catalog) {
                    System.out.printf("| %-1d | %-20s | %-18s | %-13s | %-9s |\n",
                            book.getId(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getIsbn(),
                            book.getStatus());
                }

                System.out.println("+---+----------------------+--------------------+---------------+-----------+");
                System.out.println("Total Records Displayed: " + catalog.size());
                System.out.println();

            } else if (choice == 3) {
                // Exit Section
                System.out.println("Exiting system... Thank you!");
                break;
            } else {
                System.out.println("Invalid option! Please select 1, 2, or 3.\n");
            }
        }

        scanner.close();
    }
}