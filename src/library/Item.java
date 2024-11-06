package library;

public class Item {
    private IBook data;
    private Item next;
    public Item(IBook data, Item next) {
        this.data = data;
        this.next = next;
    }
    public IBook getData() {
        return data;
    }
    public void setData(IBook data) {
        this.data = data;
    }
    public Item getNext() {
        return next;
    }
    public void setNext(Item next) {
        this.next = next;
    }
}