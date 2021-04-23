package chap08_LinkedList;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode<Integer> listNode5 = new ListNode<>(5);
        ListNode<Integer> listNode4 = new ListNode<>(4, listNode5);
        ListNode<Integer> listNode3 = new ListNode<>(3, listNode4);
        ListNode<Integer> listNode2 = new ListNode<>(2, listNode3);
        ListNode<Integer> listNode1 = new ListNode<>(1, listNode2);

        ListNode<Integer> reverse = reverseBetween(listNode1, 2, 5);

        while(reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    private static <E extends Number> ListNode<E> reverseBetween(ListNode<E> head, int m, int n) {

        ListNode<E> start = new ListNode<>();
        ListNode<E> root = start;
        root.next = head;

        for (int i = 1; i < m; i++) {
            start = start.next;
        }
        ListNode<E> end = start.next;

        for (int i = 0; i < n - m; i++) {
            ListNode<E> temp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = temp;
        }

        return root.next;
    }
}
