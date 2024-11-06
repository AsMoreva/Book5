package library;

import java.util.Optional;

// класс scientificlibraryhall реализует интерфейс ihall
public class ScientificLibraryHall implements IHall {
    // поле для хранения названия зала
    private String name;
    // массив для хранения книг
    private IBook[] books;
    // переменная для хранения количества книг
    private int numberOfBooks;

    // конструктор с параметрами name и capacity
    public ScientificLibraryHall(String name, int capacity) {
        this.name = name; // устанавливает название зала
        this.books = new IBook[capacity]; // инициализирует массив книг с заданной вместимостью
        this.numberOfBooks = 0; // устанавливает количество книг в 0
    }

    public ScientificLibraryHall() {
        this.name = "Не определено";
        this.books = new IBook[0];
        this.numberOfBooks = 0;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getBookCount() {
        return 0;
    }


    @Override
    public void printAllBookTitles() {

    }

    // метод для получения количества книг
    @Override
    public int getNumberOfBooks() { return numberOfBooks; }

    // метод для вывода названий всех книг
    @Override
    public void printTitles() {
        for (IBook book : books) {
            if (book != null) System.out.println(book.getTitle()); // выводит название книги, если книга не null
        }
    }

    // метод для получения общей стоимости всех книг
    @Override
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (IBook book : books) {
            if (book != null) totalPrice += book.getPrice(); // добавляет цену книги, если книга не null
        }
        return totalPrice;
    }

    @Override
    public double getBooksSortedByPriceDesc() {
        return 0;
    }

    // метод для получения книги по индексу
    @Override
    public IBook getBookByNumber(int index) {
        if (index >= 0 && index < books.length && books[index] != null) {
            return Optional.of(books[index]).get(); // возвращает книгу, если индекс корректный и книга не null
        }
        throw new BookIndexOutOfBoundsException("неверный индекс книги.");
    }

    // метод для получения всех книг
    @Override
    public IBook[] getAllBooks() { return books.clone(); } // возвращает копию массива книг

    // метод для замены книги на новую по индексу
    @Override
    public void changeBook(int index, IBook newBook) {
        if (index >= 0 && index < books.length) {
            books[index] = newBook; // заменяет книгу на новую, если индекс корректный
        } else {
            throw new BookIndexOutOfBoundsException("неверный индекс книги.");
        }
    }

    // метод для добавления новой книги по индексу
    @Override
    public void addBook(int index, IBook newBook) {
        if (index >= 0 && index < books.length) {
            books[index] = newBook; // добавляет новую книгу, если индекс корректный
            numberOfBooks++; // увеличивает количество книг
        } else {
            throw new BookIndexOutOfBoundsException("неверный индекс книги - " + index);
        }
    }

    // метод для удаления книги по индексу
    @Override
    public void removeBook(int index) {
        if (index >= 0 && index < books.length) {
            books[index] = null; // удаляет книгу, устанавливая null
            numberOfBooks--; // уменьшает количество книг
        } else {
            throw new BookIndexOutOfBoundsException("неверный индекс книги.");
        }
    }

    @Override
    public IBook getBestBook() {
        IBook bestBook = null;
        for (IBook book : books) {
            if (book != null && (bestBook == null || book.getPrice() > bestBook.getPrice())) {
                bestBook = book;
            }
        }
        return bestBook;
    }


    // метод для получения названия зала (пока возвращает пустую строку)
    @Override
    public String getName() {
        return "";
    }

    @Override
    public IBook[] getBooks() {
        return new IBook[0];
    }
}
