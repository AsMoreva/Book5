package library;

import java.util.Optional;

// класс двусвязного списка для хранения залов научной библиотеки
class TwiceList {
    private Item2 head; // голова списка
    private int size; // количество элементов

    // вложенный класс для узла списка, хранящий зал
    private class Item2 {
        ScientificLibraryHall data; // данные зала
        Item2 next; // ссылка на следующий элемент
        Item2 prev; // ссылка на предыдущий элемент

        // конструктор для создания узла
        Item2(ScientificLibraryHall data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // конструктор для инициализации пустого двусвязного списка
    public TwiceList() {
        this.head = new Item2(null); // голова не хранит данных
        this.head.next = this.head.prev = this.head; // циклический список
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

    // получение зала по индексу
    public Optional<ScientificLibraryHall> getItem(int index) {
        if (index < 0 || index >= size) { // проверка на корректность индекса
            return Optional.empty(); // возвращаем пустой Optional, если индекс некорректен
        }
        Item2 current = head.next; // начинаем с первого элемента
        for (int i = 0; i < index; i++) {
            current = current.next; // перемещаемся к следующему элементу
        }
        return Optional.of(current.data); // возвращаем зал, найденный по индексу
    }

    // добавление зала по индексу
    public boolean addItem(int index, ScientificLibraryHall hall) {
        if (index < 0 || index > size) { // проверка на корректность индекса
            return false;
        }
        Item2 newItem = new Item2(hall); // создание нового узла с залом
        Item2 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // перемещаемся к нужной позиции для вставки
        }
        newItem.next = current.next; // связываем новый узел с последующим элементом
        newItem.prev = current; // связываем новый узел с предыдущим элементом
        current.next.prev = newItem; // обновляем ссылку предыдущего элемента
        current.next = newItem; // вставляем новый узел в список
        size++; // увеличиваем размер списка
        return true;
    }

    // удаление зала по индексу
    public boolean removeItem(int index) {
        if (index < 0 || index >= size) { // проверка на корректность индекса
            return false;
        }
        Item2 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // перемещаемся к нужной позиции для удаления
        }
        current.next = current.next.next; // переподключаем ссылки для удаления узла
        current.next.prev = current; // обновляем ссылку предыдущего элемента
        size--; // уменьшаем размер списка
        return true;
    }
}
