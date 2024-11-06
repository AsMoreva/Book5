package library;

// класс book реализует интерфейс ibook
public class Book implements IBook {
    // поле для хранения автора книги
    private String author;
    // поле для хранения названия книги
    private String title;
    // поле для хранения цены книги
    private double price;
    // поле для хранения года издания книги
    private int year;

    // конструктор по умолчанию
    public Book() {
        this.author = "не определено"; // автор по умолчанию
        this.title = "не определено"; // название по умолчанию
        this.price = 0.0; // цена по умолчанию
        this.year = 0; // год издания по умолчанию
    }

    // конструктор с параметрами author, title, price и year
    public Book(String author, String title, double price, int year) {
        this.author = author; // устанавливает автора
        this.title = title; // устанавливает название
        this.price = price; // устанавливает цену
        this.year = year; // устанавливает год издания
    }

    // конструктор с параметрами author и year
    public Book(String author, int year) {
        this(); // вызывает конструктор по умолчанию
        this.author = author; // устанавливает автора
        this.year = year; // устанавливает год издания
    }

    // метод для получения автора книги
    @Override
    public String getAuthor() { return author; }

    // метод для установки автора книги
    @Override
    public void setAuthor(String author) { this.author = author; }

    // метод для получения названия книги
    @Override
    public String getTitle() { return title; }

    // метод для установки названия книги
    @Override
    public void setTitle(String title) { this.title = title; }

    // метод для получения цены книги
    @Override
    public double getPrice() { return price; }

    // метод для установки цены книги
    @Override
    public void setPrice(double price) {
        // проверяет, что цена не отрицательная
        if (price < 0) throw new InvalidBookPriceException("цена не может быть отрицательной.");
        this.price = price;
    }

    @Override
    public double getBestBook() {
        return 0;
    }

    @Override
    public void setBestBook(double price) {

    }

    // метод для получения года издания книги
    @Override
    public int getYear() { return year; }

    // метод для установки года издания книги
    @Override
    public void setYear(int year) { this.year = year; }
}