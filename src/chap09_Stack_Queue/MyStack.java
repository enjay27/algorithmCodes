package chap09_Stack_Queue;

class MyStack {

    MyStack last;
    MyStack next;
    int val;

    /** Initialize your data structure here. */
    public MyStack() {
        val = 0;
        next = null;
        last = this;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        last = new MyStack();
        last.val = x;
        last.next = this;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int val = last.val;
        last = last.next;
        return val;
    }

    /** Get the top element. */
    public int top() {
        return last.val;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return last.next == null;
    }
}