package baitap2;

import java.time.LocalDate;

public class LoanRecord {
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanRecord(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public User getUser() { return user; }
    public Book getBook() { return book; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    @Override
    public String toString() {
        return book.getTitle() + " borrowed by " + user.getName() + " on " + loanDate +
                (isReturned() ? ", returned on " + returnDate : ", not returned yet");
    }
}

