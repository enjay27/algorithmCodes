package chap10_Deque;

import java.util.ArrayList;
import java.util.HashMap;

public class DoublyListNode<T> {
    T val;
    DoublyListNode<T> next;
    DoublyListNode<T> prev;

    public DoublyListNode(T val) {
        this.val = val;
    }

    public DoublyListNode(T val, DoublyListNode<T> next, DoublyListNode<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
