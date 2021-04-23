package chap08_LinkedList;

public class ReverseLinkedList1 {
    public static void main(String[] args) {
        ListNode<Integer> listNode5 = new ListNode<>(5);
        ListNode<Integer> listNode4 = new ListNode<>(4, listNode5);
        ListNode<Integer> listNode3 = new ListNode<>(3, listNode4);
        ListNode<Integer> listNode2 = new ListNode<>(2, listNode3);
        ListNode<Integer> listNode1 = new ListNode<>(1, listNode2);

        ListNode<Integer> reverse = reverseNodeV1(listNode1);

        while(reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    private static <E extends Number> ListNode<E> reverseNodeV1(ListNode<E> head) {
        return reverse(head, null);
    }

    private static <E extends Number> ListNode<E> reverse(ListNode<E> node, ListNode<E> prev) {
        if (node == null)
            return prev;
        ListNode<E> next = node.next;
        node.next = prev;
        return reverse(next, node);
    }

    private static <E extends Number> ListNode<E> reverseNodeV2(ListNode<E> head) {
        ListNode<E> node = head;
        ListNode<E> next = node.next;
        ListNode<E> prev = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
