package library; // пакет, в котором находится класс

import java.util.Optional;

// класс Childrenlibrary реализует интерфейс ilibrary
public class ChildrenLibrary implements ILibrary {
    // массив для хранения залов библиотеки
    private IHall[] halls;

    // конструктор с параметром halls
    public ChildrenLibrary(IHall[] halls) {
        this.halls = halls.clone(); // клонирует массив залов для хранения
    }

    // метод для получения количества залов
    @Override
    public int getNumberOfHalls() {
        return halls.length;
    }

    // метод для получения общего количества книг во всех залах
    @Override
    public int getTotalNumberOfBooks() {
        int totalBooks = 0;
        for (IHall hall : halls) {
            totalBooks += hall.getNumberOfBooks(); // суммирует количество книг из каждого зала
        }
        return totalBooks;
    }

    // метод для получения общей стоимости всех книг во всех залах
    @Override
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (IHall hall : halls) {
            totalPrice += hall.getTotalPrice(); // суммирует стоимость книг из каждого зала
        }
        return totalPrice;
    }

    // метод для получения всех залов (возвращает пустой массив вместо копии залов)
    @Override
    public IHall[] getHalls() {
        return new IHall[0];
    }

    // метод для получения зала по индексу
    @Override
    public Optional<IHall> getHallByNumber(int index) {
        if (index >= 0 && index < halls.length) {
            return Optional.of(halls[index]); // возвращает зал, если индекс корректный
        }
        return Optional.empty();
    }

    // метод для получения книги по глобальному индексу в библиотеке
    @Override
    public Optional<IBook> getBookByNumberInLibrary(int index) {
        int count = 0;
        for (IHall hall : halls) {
            for (int i = 0; i < hall.getNumberOfBooks(); i++) {
                Optional<IBook> book = Optional.of(hall.getBookByNumber(i));
                if (book.isPresent()) {
                    if (count == index) {
                        return book; // возвращает книгу, если найденный индекс соответствует
                    }
                    count++;
                }
            }
        }
        return Optional.empty();
    }

    // метод для получения лучшей книги среди всех залов (по наивысшей цене)
    @Override
    public IBook getBestBook() {
        IBook bestBook = null;
        for (IHall hall : halls) {
            IBook hallBest = hall.getBestBook();
            if (hallBest != null && (bestBook == null || hallBest.getPrice() > bestBook.getPrice())) {
                bestBook = hallBest;
            }
        }
        return bestBook;
    }

    // метод для вывода деталей всех залов
    @Override
    public void printAllHallDetails() {
        for (int i = 0; i < halls.length; i++) {
            IHall hall = halls[i];
            System.out.println("зал " + (i + 1) + ": " + hall.getName() + " | количество книг: " + hall.getNumberOfBooks());
            hall.printTitles(); // выводит названия книг в зале
            System.out.println();
        }
    }

    @Override
    public int getBookCount() {
        return 0;
    }

    @Override
    public Optional<Object> getBookByNumber(int i) {
        return Optional.empty();
    }

    @Override
    public void printHallsInfo() {

    }

    @Override
    public IBook[] getBooksSortedByPriceDesc() {
        int arrSize = 0; // Вычисляем размер большого зала
        for (int i =0; i < halls.length; i++){
            for (int j =0; j < halls[i].getNumberOfBooks(); j++){
                arrSize++;
            }
        }

        IHall bigHall = new ChildrenLibraryHall("name", arrSize); // Создание большого зала со всеми книгами всех залов
        int counter = 0;
        for (int i =0; i < halls.length; i++){
            for (int j =0; j < halls[i].getNumberOfBooks(); j++){
                bigHall.addBook(counter, halls[i].getBookByNumber(j));
                counter++;
            }
        }

        IBook[] bookArr = bigHall.getAllBooks(); // Извлечение массива с книгами
        // Сортировка массива
        for (int i = 0; i < bookArr.length - 1; i++) {
            for (int j = 0; j < bookArr.length - i - 1; j++) {
                if (bookArr[j].getPrice() < bookArr[j + 1].getPrice()) {
                    IBook temp = bookArr[j];
                    bookArr[j] = bookArr[j + 1];
                    bookArr[j + 1] = temp;
                }
            }
        }

        return bookArr;
    }

    // метод для замены зала по индексу
    @Override
    public void replaceHall(int index, IHall newHall) throws HallIndexOutOfBoundsException {
        if (index < 0 || index >= halls.length) {
            throw new HallIndexOutOfBoundsException("индекс зала вне диапазона");
        }
        halls[index] = newHall;
    }

    // метод для замены книги по глобальному индексу в библиотеке
    @Override
    public void replaceBook(int index, IBook newBook) throws BookIndexOutOfBoundsException {
        int count = 0;
        for (IHall hall : halls) {
            for (int i = 0; i < hall.getNumberOfBooks(); i++) {
                if (count == index) {
                    hall.changeBook(i, newBook); // заменяет книгу, если найденный индекс соответствует
                    return;
                }
                count++;
            }
        }
        throw new BookIndexOutOfBoundsException("индекс книги вне диапазона");
    }

    // метод для добавления книги по глобальному индексу в библиотеке
    @Override
    public void addBook(int index, IBook newBook) throws BookIndexOutOfBoundsException {
        int count = 0;
        for (IHall hall : halls) {
            for (int i = 0; i < hall.getNumberOfBooks(); i++) {
                if (count == index) {
                    hall.addBook(i, newBook); // добавляет книгу, если найденный индекс соответствует
                    return;
                }
                count++;
            }
        }
        throw new BookIndexOutOfBoundsException("индекс книги вне диапазона");
    }

    // метод для удаления книги по глобальному индексу в библиотеке
    @Override
    public void removeBook(int index) throws BookIndexOutOfBoundsException {
        int count = 0;
        for (IHall hall : halls) {
            for (int i = 0; i < hall.getNumberOfBooks(); i++) {
                if (count == index) {
                    hall.removeBook(i); // удаляет книгу, если найденный индекс соответствует
                    return;
                }
                count++;
            }
        }
        throw new BookIndexOutOfBoundsException("индекс книги вне диапазона");
    }

}
