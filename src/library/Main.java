package library;

public class Main {
    public static void main(String[] args) {
        // создание экземпляров ChildrenLibraryHall и ScientificLibraryHall
        ChildrenLibraryHall childrenHall = new ChildrenLibraryHall("Детский Зал", 5);
        ScientificLibraryHall scientificHall = new ScientificLibraryHall("Научный Зал", 5);

        // добавление книг в детский зал
        childrenHall.addBook(0, new ChildrenBook("А. Пушкин", "Сказка о царе Салтане", 150, 1831, 6));
        childrenHall.addBook(1, new ChildrenBook("С. Михалков", "Дядя Стёпа", 200, 1936, 3));
        childrenHall.addBook(2, new ChildrenBook("Л. Кэрролл", "Алиса в стране чудес", 500, 1862, 12));

        // добавление книг в научный зал
        scientificHall.addBook(0, new ScientificBook("И. Ньютон", "Математические начала натуральной философии", 500, 1687, 9.8));
        scientificHall.addBook(1, new ScientificBook("Ч. Дарвин", "Происхождение видов", 450, 1859, 8.7));
        scientificHall.addBook(2, new ScientificBook("Ч. Дарвин", "Происхождение видов 2", 350, 1759, 1.5));

        // создание массивов залов для библиотек
        IHall[] childrenHalls = {childrenHall};
        IHall[] scientificHalls = {scientificHall};

        // создание экземпляров библиотек
        ChildrenLibrary childrenLibrary = new ChildrenLibrary(childrenHalls);
        ScientificLibrary scientificLibrary = new ScientificLibrary(scientificHalls);

        // работа с детской библиотекой
        System.out.println("Детская библиотека:");
        childrenLibrary.printAllHallDetails();
        System.out.println("Общее количество книг: " + childrenLibrary.getTotalNumberOfBooks());
        System.out.println("Общая стоимость книг: " + childrenLibrary.getTotalPrice());

        // сортировка и вывод книг детской библиотеки по убыванию цены
        System.out.println("\nКниги в детской библиотеке, отсортированные по убыванию цены:");
        IBook[] sortedChildrenBooks = childrenLibrary.getBooksSortedByPriceDesc();
        for (IBook book : sortedChildrenBooks) {
            System.out.println(book.getTitle() + " - " + book.getPrice() + " руб.");
        }

        // работа с научной библиотекой
        System.out.println("\nНаучная библиотека:");
        scientificLibrary.printAllHallDetails();
        System.out.println("Общее количество книг: " + scientificLibrary.getTotalNumberOfBooks());
        System.out.println("Общая стоимость книг: " + scientificLibrary.getTotalPrice());

        // сортировка и вывод книг научной библиотеки по убыванию цены
        System.out.println("\nКниги в научной библиотеке, отсортированные по убыванию цены:");
        IBook[] sortedScientificBooks = scientificLibrary.getBooksSortedByPriceDesc();
        for (IBook book : sortedScientificBooks) {
            System.out.println(book.getTitle() + " - " + book.getPrice() + " руб.");
        }

        // Замена зала в научной библиотеке
        try {
            ScientificLibraryHall newScientificHall = new ScientificLibraryHall("Новый Научный Зал", 6);
            newScientificHall.addBook(0, new ScientificBook("Книга 1", "Описание 1", 300, 2000, 8.5));
            newScientificHall.addBook(1, new ScientificBook("Книга 2", "Описание 2", 400, 2001, 9.0));
            newScientificHall.addBook(2, new ScientificBook("Книга 3", "Описание 3", 600, 2002, 8.5));
            scientificLibrary.replaceHall(0, newScientificHall); // Важно: вызов метода замены зала
            System.out.println("\nЗал в научной библиотеке заменен:");
            scientificLibrary.printAllHallDetails();
        } catch (HallIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Замена книги в научной библиотеке
        try {
            scientificLibrary.replaceBook(0, new ScientificBook("М. Планк", "Теория квантов", 600, 1900, 9.5));
            System.out.println("\nКнига в научной библиотеке заменена:");
            scientificLibrary.printAllHallDetails();
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Добавление книги в научную библиотеку
        try {
            scientificLibrary.addBook(1, new ScientificBook("А. Эйнштейн", "Теория относительности", 700, 1915, 10.0));
            System.out.println("\nНовая книга Теория относительности добавлена в научную библиотеку:");
            scientificLibrary.printAllHallDetails();
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Удаление книги из научной библиотеки
        try {
            scientificLibrary.removeBook(0);
            System.out.println("\nКнига удалена из научной библиотеки:");
            scientificLibrary.printAllHallDetails();
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        IBook bestBook = scientificLibrary.getBestBook();
        System.out.println("\nСамая дорогая книга в научной библиотеке:");
        if (bestBook != null) {
            System.out.println(bestBook.getTitle() + " - " +
                    bestBook.getPrice() + " руб.");
        } else {
            System.out.println("Книг нет.");
        }
    }
}

        
