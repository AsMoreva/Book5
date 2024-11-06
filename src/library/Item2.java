package library;

public class Item2 {
    private IHall data;
    private Item2 prev;
    private Item2 next;
    public Item2(IHall data, Item2 prev, Item2 next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    public IHall getData() {
        return data;
    }
    public void setData(IHall data) {
        this.data = data;
    }
    public Item2 getPrev() {
        return prev;
    }
    public void setPrev(Item2 prev) {
        this.prev = prev;
    }
    public Item2 getNext() {
        return next;
    }
    public void setNext(Item2 next) {
        this.next = next;
    }
}