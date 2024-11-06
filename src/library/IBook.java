package library;

public interface IBook {
    String getTitle();
    void setTitle(String title);

    String getAuthor();
    void setAuthor(String author);

    int getYear();
    void setYear(int year);

    double getPrice();
    void setPrice(double price);

    double getBestBook();
    void setBestBook(double price);
}