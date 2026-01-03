package Bookmark;

import java.util.List;
import java.util.Scanner;

public class Manu {

    public static void main(String[] args) {

        BookmarkManager manager = new BookmarkManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add book");
            System.out.println("2. Show all books");
            System.out.println("3. Show books by status");
            System.out.println("4. Show books by year");
            System.out.println("5. Change book status");
            System.out.println("6. Remove book");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    manager.addBook(new Book(title, author, year));
                }

                case 2 -> {
                    List<Book> books = manager.getAllBooks();
                    for (Book b : books) {
                        System.out.println(b);
                    }
                }

                case 3 -> {
                    System.out.println("1. PLAN_TO_READ");
                    System.out.println("2. READING");
                    System.out.println("3. READ");

                    int s = scanner.nextInt();
                    scanner.nextLine();

                    BookStatus status = switch (s) {
                        case 1 -> BookStatus.PLAN_TO_READ;
                        case 2 -> BookStatus.READING;
                        case 3 -> BookStatus.READ;
                        default -> null;
                    };

                    if (status != null) {
                        List<Book> result = manager.filterByStatus(status);
                        for (Book b : result) {
                            System.out.println(b);
                        }
                    }
                }

                case 4 -> {
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    List<Book> result = manager.filterByYear(year);
                    for (Book b : result) {
                        System.out.println(b);
                    }
                }

                case 5 -> {
                    System.out.print("Book title: ");
                    String title = scanner.nextLine();

                    System.out.println("1. PLAN_TO_READ");
                    System.out.println("2. READING");
                    System.out.println("3. READ");

                    int s = scanner.nextInt();
                    scanner.nextLine();

                    BookStatus status = switch (s) {
                        case 1 -> BookStatus.PLAN_TO_READ;
                        case 2 -> BookStatus.READING;
                        case 3 -> BookStatus.READ;
                        default -> null;
                    };

                    if (status != null) {
                        manager.changeBookStatus(title, status);
                    }
                }

                case 6 -> {
                    System.out.print("Book title: ");
                    String title = scanner.nextLine();
                    manager.removeBook(title);
                }

                case 7 -> running = false;
            }
        }
    }
}