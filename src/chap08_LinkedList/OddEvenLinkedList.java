package chap08_LinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> listNode7 = new ListNode<>(7);
        ListNode<Integer> listNode6 = new ListNode<>(4, listNode7);
        ListNode<Integer> listNode5 = new ListNode<>(6, listNode6);
        ListNode<Integer> listNode4 = new ListNode<>(5, listNode5);
        ListNode<Integer> listNode3 = new ListNode<>(3, listNode4);
        ListNode<Integer> listNode2 = new ListNode<>(1, listNode3);
        ListNode<Integer> listNode1 = new ListNode<>(2, listNode2);

        ListNode<Integer> oddEvent = oddEventList(listNode1);

        while(oddEvent != null) {
            System.out.println(oddEvent.val);
            oddEvent = oddEvent.next;
        }
    }

    private static <E extends Number> ListNode<E> oddEventList(ListNode<E> head) {
        if (head.next == null)
            return head;

        ListNode<E> even = head.next;
        ListNode<E> even_head = even;
        ListNode<E> odd = head;

        while (even != null) {
            odd.next = even.next;
            odd = even.next;

            even.next = odd.next;
            even = odd.next;
        }

        odd.next = even_head;

        return head;
    }
}
