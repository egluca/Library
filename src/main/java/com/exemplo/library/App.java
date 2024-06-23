package com.example.library;

import com.example.library.model.Book;
import com.example.library.service.Library;

import java.util.Scanner;

public class App {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    findBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. List Books");
        System.out.println("4. Find Book by ISBN");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        Book book = new Book(title, author, isbn);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
        System.out.println("Book removed successfully.");
    }

    private static void listBooks() {
        System.out.println("Listing all books:");
        for (Book book : library.listBooks()) {
            System.out.println(book);
        }
    }

    private static void findBook() {
        System.out.print("Enter ISBN to find: ");
        String isbn = scanner.nextLine();
        Book book = library.findBookByIsbn(isbn);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
