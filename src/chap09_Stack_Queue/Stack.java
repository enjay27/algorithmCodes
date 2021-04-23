package chap09_Stack_Queue;

import chap08_LinkedList.ListNode;

public class Stack<T> {

    ListNode<T> last = null;

    public void push(T val) {
        last = new ListNode<>(val, last);
    }

    public T pop() {
        T val = last.val;
        last = last.next;
        return val;
    }

    public boolean isEmpty() {
        return last == null;
    }
}
