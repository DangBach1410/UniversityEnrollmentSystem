package baitap2;

import java.time.LocalDate;
import java.util.*;

public class LibrarySystem {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();
    private ArrayList<LoanRecord> loanRecords = new ArrayList<>();

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Add some books
        library.addBook(new Book("B1", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("B2", "Effective Java", "Joshua Bloch"));

        // Add users
        library.addUser(new User("U1", "Alice"));
        library.addUser(new User("U2", "Bob"));

        // Borrow books
        library.borrowBook("U1", "B1");
        library.borrowBook("U2", "B2");

        // Show borrowed books
        library.showBorrowedBooks();

        // Return a book
        library.returnBook("B1");

        // Show returned books
        library.showReturnedBooks();

        // Show user's loan history
        library.showUserLoanHistory("U1");
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public boolean borrowBook(String userId, String bookId) {
        Book book = books.get(bookId);
        User user = users.get(userId);
        if (book != null && user != null && book.isAvailable()) {
            book.setAvailable(false);
            loanRecords.add(new LoanRecord(user, book, LocalDate.now()));
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId) {
        for (LoanRecord record : loanRecords) {
            if (record.getBook().getId().equals(bookId) && !record.isReturned()) {
                record.setReturnDate(LocalDate.now());
                record.getBook().setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public void showBorrowedBooks() {
        System.out.println("Currently Borrowed Books:");
        for (LoanRecord record : loanRecords) {
            if (!record.isReturned()) {
                System.out.println(record);
            }
        }
    }

    public void showReturnedBooks() {
        System.out.println("Returned Books:");
        for (LoanRecord record : loanRecords) {
            if (record.isReturned()) {
                System.out.println(record);
            }
        }
    }

    public void showUserLoanHistory(String userId) {
        System.out.println("Loan History for User: " + userId);
        for (LoanRecord record : loanRecords) {
            if (record.getUser().getId().equals(userId)) {
                System.out.println(record);
            }
        }
    }
}

