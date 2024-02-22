import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.title + "' added to the library.");
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book '" + book.title + "' removed from the library.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.author.equals(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.title.equals(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public int countBooks() {
        return books.size();
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів книг
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        // Створення об'єкта бібліотеки
        Library library = new Library();

        // Додавання книг до бібліотеки
        library.addBook(book1);
        library.addBook(book2);

        // Пошук книг за автором і виведення результату
        List<Book> authorSearchResult = library.searchByAuthor("J.D. Salinger");
        System.out.println("Books by J.D. Salinger: " + authorSearchResult);

        // Видалення книги з бібліотеки
        library.removeBook(book1);

        // Підрахунок кількості книг у бібліотеці
        int numberOfBooks = library.countBooks();
        System.out.println("Number of books in the library: " + numberOfBooks);
    }
}
