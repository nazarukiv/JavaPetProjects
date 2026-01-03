package Bookmark;

import java.util.ArrayList;
import java.util.List;

public class BookmarkManager {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean changeBookStatus(String title, BookStatus status) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setStatus(status);
                return true;
            }
        }
        return false;
    }


    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> filterByStatus(BookStatus status) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getStatus() == status) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> filterByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublicationYear() == year) {
                result.add(book);
            }
        }
        return result;
    }
}