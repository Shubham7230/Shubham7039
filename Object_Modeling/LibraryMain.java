import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(title + " by " + author);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
    }

    void showBooks() {
        for (Book b : books) {
            b.display();
        }
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("Atomic Habits", "James Clear");
        Book b3 = new Book("Ikigai", "Hector Garcia");

        Library lib1 = new Library();
        Library lib2 = new Library();

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        System.out.println("Library 1 Books:");
        lib1.showBooks();

        System.out.println("Library 2 Books:");
        lib2.showBooks();
    }
}
