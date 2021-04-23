package chap08_LinkedList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode<Integer> listNode1_3 = new ListNode<>(4);
        ListNode<Integer> listNode1_2 = new ListNode<>(3, listNode1_3);
        ListNode<Integer> listNode1_1 = new ListNode<>(1, listNode1_2);
        ListNode<Integer> listNode2_3 = new ListNode<>(4);
        ListNode<Integer> listNode2_2 = new ListNode<>(2, listNode2_3);
        ListNode<Integer> listNode2_1 = new ListNode<>(1, listNode2_2);

        ListNode<Integer> oddEvent = mergeTwoSortedListsV1(listNode1_1, listNode2_1);

        while(oddEvent != null) {
            System.out.println(oddEvent.val);
            oddEvent = oddEvent.next;
        }
    }

    private static ListNode<Integer> mergeTwoSortedListsV1(ListNode<Integer> node1, ListNode<Integer> node2) {
        ListNode<Integer> cal = new ListNode<>();
        ListNode<Integer> first = cal;
        ListNode<Integer> nextNode1 = node1;
        ListNode<Integer> nextNode2 = node2;

        while (true) {
            if(nextNode1 == null && nextNode2 == null)
                break;
            else if (nextNode1 != null && nextNode2 != null) {
                if (nextNode1.val > nextNode2.val) {
                    cal.next = nextNode2;
                    nextNode2 = nextNode2.next;
                }
                else {
                    cal.next = nextNode1;
                    nextNode1 = nextNode1.next;
                }
            } else if (nextNode1 != null && nextNode2 == null) {
                cal.next = nextNode1;
                nextNode1 = nextNode1.next;
            } else if (nextNode2 != null && nextNode1 == null) {
                cal.next = nextNode2;
                nextNode2 = nextNode2.next;
            }
            cal = cal.next;
        }
        return first.next;
    }
}
