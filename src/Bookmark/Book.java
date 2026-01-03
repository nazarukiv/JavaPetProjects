package Bookmark;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private BookStatus status;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = BookStatus.PLAN_TO_READ;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void markAsReading() {
        this.status = BookStatus.READING;
    }

    public void markAsRead() {
        this.status = BookStatus.READ;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                " | Author: " + author +
                " | Year: " + publicationYear +
                " | Status: " + status;
    }
}