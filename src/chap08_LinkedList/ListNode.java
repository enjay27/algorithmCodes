package chap08_LinkedList;

public class ListNode<T> {
    public T val;
    public ListNode<T> next = null;
    public ListNode(){};

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}
