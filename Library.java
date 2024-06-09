import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean checkedOut;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Other getters and setters
}

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Enter book details (title, author, ISBN), or type 'exit' to finish:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] bookDetails = input.split(",");
            if (bookDetails.length != 3) {
                System.out.println("Invalid input format. Please enter title, author, and ISBN separated by commas.");
                continue;
            }
            String title = bookDetails[0].trim();
            String author = bookDetails[1].trim();
            String isbn = bookDetails[2].trim();
            Book book = new Book(title, author, isbn);
            library.addBook(book);
        }

        library.displayBooks();
        scanner.close();
    }
}