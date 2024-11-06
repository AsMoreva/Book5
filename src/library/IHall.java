package library;

// импортируем класс Optional из пакета java.util

// объявляем интерфейс IHall
public interface IHall {
    void setName(String name);

    int getBookCount();

    void printAllBookTitles();

    // метод для получения количества книг
    int getNumberOfBooks();

    // метод для вывода названий книг
    void printTitles();

    // метод для получения общей цены книг
    double getTotalPrice();

    double getBooksSortedByPriceDesc();

    // метод для получения книги по номеру, возвращает Optional
    IBook getBookByNumber(int index);

    // метод для получения всех книг, возвращает массив IBook
    IBook[] getAllBooks();

    // метод для замены книги на новую по индексу
    void changeBook(int index, IBook newBook);

    // метод для добавления новой книги по индексу
    void addBook(int index, IBook newBook);

    // метод для удаления книги по индексу
    void removeBook(int index);

    // метод для получения лучшей книги по какому-то критерию
    IBook getBestBook();

    // метод для получения названия
    String getName();

    IBook[] getBooks();
}