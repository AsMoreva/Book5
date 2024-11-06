package library;

import java.util.Optional;

// класс односвязного списка для хранения книг
class FirstList {
    private Item top; // голова списка
    private int size; // количество элементов

    // вложенный класс для узла списка, хранящий книгу
    private class Item {
        Book data; // данные книги
        Item next; // ссылка на следующий элемент

        // конструктор для создания узла
        Item(Book data) {
            this.data = data;
            this.next = null;
        }
    }

    // конструктор для инициализации пустого списка
    public FirstList() {
        this.top = new Item(null); // голова не хранит данных
        this.top.next = this.top; // циклический список
        this.size = 0;
    }

    // проверка, пуст ли список
    public boolean isEmpty() {
        return size == 0;
    }

    // получение размера списка
    public int getSize() {
        return size;
    }

    // получение книги по индексу
    public Optional<Book> getItem(int index) {
        if (index < 0 || index >= size) { // проверка на корректность индекса
            return Optional.empty(); // возвращаем пустой Optional, если индекс некорректен
        }
        Item current = top.next; // начинаем с первого элемента
        for (int i = 0; i < index; i++) {
            current = current.next; // перемещаемся к следующему элементу
        }
        return Optional.of(current.data); // возвращаем книгу, найденную по индексу
    }

    // добавление книги по индексу
    public boolean addItem(int index, Book book) {
        if (index < 0 || index > size) { // проверка на корректность индекса
            return false;
        }
        Item newItem = new Item(book); // создание нового узла с книгой
        Item current = top;
        for (int i = 0; i < index; i++) {
            current = current.next; // перемещаемся к нужной позиции для вставки
        }
        newItem.next = current.next; // связываем новый узел с последующим элементом
        current.next = newItem; // вставляем новый узел в список
        size++; // увеличиваем размер списка
        return true;
    }

    // удаление книги по индексу
    public boolean removeItem(int index) {
        if (index < 0 || index >= size) { // проверка на корректность индекса
            return false;
        }
        Item current = top;
        for (int i = 0; i < index; i++) {
            current = current.next; // перемещаемся к нужной позиции для удаления
        }
        current.next = current.next.next; // переподключаем ссылки для удаления узла
        size--; // уменьшаем размер списка
        return true;
    }
}
