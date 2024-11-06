package library;

// класс childrenbook наследует класс book
public class ChildrenBook extends Book {
    // поле для хранения минимального возраста
    private int minAge;

    // конструктор по умолчанию
    public ChildrenBook() {
        super(); // вызывает конструктор суперкласса book
        this.minAge = 0; // устанавливает минимальный возраст в 0
    }

    // конструктор с параметрами author и year
    public ChildrenBook(String author, int year) {
        super(author, year); // вызывает конструктор суперкласса book с двумя параметрами
        this.minAge = 0; // устанавливает минимальный возраст в 0
    }

    // конструктор с параметрами author, title, price, year и minAge
    public ChildrenBook(String author, String title, double price, int year, int minAge) {
        super(author, title, price, year); // вызывает конструктор суперкласса book с четырьмя параметрами
        this.minAge = minAge; // устанавливает минимальный возраст
    }

    // метод для получения минимального возраста
    public int getMinAge() { return minAge; }

    // метод для установки минимального возраста
    public void setMinAge(int minAge) { this.minAge = minAge; }
}