package chap08_LinkedList;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode<Integer> listNode6 = new ListNode<>(6);
        ListNode<Integer> listNode5 = new ListNode<>(5, listNode6);
        ListNode<Integer> listNode4 = new ListNode<>(4, listNode5);
        ListNode<Integer> listNode3 = new ListNode<>(3, listNode4);
        ListNode<Integer> listNode2 = new ListNode<>(2, listNode3);
        ListNode<Integer> listNode1 = new ListNode<>(1, listNode2);

        ListNode<Integer> swapped = swapPairsV2(listNode1);

        while(swapped != null) {
            System.out.println(swapped.val);
            swapped = swapped.next;
        }
    }

    private static <E extends Number> ListNode<E> swapPairsV1(ListNode<E> head) {
        ListNode<E> prev = new ListNode<>();
        ListNode<E> root = prev;
        prev.next = head;
        while (head != null) {
            ListNode<E> b = head.next;
            head.next = b.next;
            b.next = head;

            prev.next = b;

            head = head.next;
            prev = prev.next.next;
        }
        return root.next;
    }

    private static <E extends Number> ListNode<E> swapPairsV2(ListNode<E> head) {
        if (head != null) {
            ListNode<E> p = head.next;

            head.next = swapPairsV2(p.next);
            p.next = head;
            return p;
        }
        return head;
    }
}
