package library;

import java.util.Optional;

public interface ILibrary {
    int getNumberOfHalls();
    int getTotalNumberOfBooks();
    double getTotalPrice();
    IHall[] getHalls();
    Optional<IHall> getHallByNumber(int index);
    Optional<IBook> getBookByNumberInLibrary(int index);
    void replaceHall(int index, IHall newHall);
    void replaceBook(int index, IBook newBook);
    void addBook(int index, IBook newBook);
    void removeBook(int index);
    IBook getBestBook();

    void printAllHallDetails();

    int getBookCount();

    Optional<Object> getBookByNumber(int i);

    void printHallsInfo();

    IBook[] getBooksSortedByPriceDesc();
}