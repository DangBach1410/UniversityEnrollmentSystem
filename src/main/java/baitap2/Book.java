package baitap2;

import java.time.LocalDate;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available = true;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author + (available ? " (Available)" : " (Borrowed)");
    }
}

