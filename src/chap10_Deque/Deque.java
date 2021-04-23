package chap10_Deque;

public class Deque<T> {
    DoublyListNode<T> head;
    DoublyListNode<T> tail;
    int size;
    int length = 0;

    public Deque(DoublyListNode<T> head, DoublyListNode<T> tail, int k) {
        this.head = head;
        this.tail = tail;
        this.size = k;
    }

    public boolean insertFront(DoublyListNode<T> node, DoublyListNode<T> newNode) {
        if(length == size)
            return false;
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        length++;
        if(length == size) {
            head.prev = tail;
            tail.next = head;
        }
        return true;
    }

    public boolean insertLast(DoublyListNode<T> node, DoublyListNode<T> newNode) {
        if(length == size)
            return false;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length++;
        if(length == size) {
            head.prev = tail;
            tail.next = head;
        }
        return true;
    }

    public boolean deleteFront() {
        if(length == 0)
            return false;

        head = head.next;
        head.prev = null;
        if(length == size)
            tail.next = null;
        length++;
        return true;
    }

    public boolean deleteLast() {
        if(length == 0)
            return false;

        tail = tail.prev;
        tail.next = null;
        if(length == size)
            head.prev = null;
        length++;
        return true;
    }

    public T getFront() {
        return head.val;
    }

    public T getRear() {
        return tail.val;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
    }
}
