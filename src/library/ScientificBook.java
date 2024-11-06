package library;

// класс ScientificBook наследует класс Book
public class ScientificBook extends Book {
    // поле для хранения индекса цитирования
    private double citationIndex;

    // конструктор по умолчанию
    public ScientificBook() {
        super(); // вызывает конструктор суперкласса Book
        this.citationIndex = 0.0; // устанавливает индекс цитирования в 0.0
    }

    // конструктор с параметрами author и year
    public ScientificBook(String author, int year) {
        super(author, year); // вызывает конструктор суперкласса Book с двумя параметрами
        this.citationIndex = 0.0; // устанавливает индекс цитирования в 0.0
    }

    // конструктор с параметрами author, title, price, year и citationIndex
    public ScientificBook(String author, String title, double price, int year, double citationIndex) {
        super(author, title, price, year); // вызывает конструктор суперкласса Book с четырьмя параметрами
        this.citationIndex = citationIndex; // устанавливает индекс цитирования
    }

    // метод для получения индекса цитирования
    public double getCitationIndex() { return citationIndex; }

    // метод для установки индекса цитирования
    public void setCitationIndex(double citationIndex) { this.citationIndex = citationIndex; }
}