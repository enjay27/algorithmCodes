package chap08_LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode<Integer> listNode1_3 = new ListNode<>(4);
        ListNode<Integer> listNode1_2 = new ListNode<>(6, listNode1_3);
        ListNode<Integer> listNode1_1 = new ListNode<>(5, listNode1_2);
        ListNode<Integer> listNode2_3 = new ListNode<>(3);
        ListNode<Integer> listNode2_2 = new ListNode<>(4, listNode2_3);
        ListNode<Integer> listNode2_1 = new ListNode<>(2, listNode2_2);

        ListNode<Integer> twoNumbers = addTwoNumbersV1(listNode1_1, listNode2_1);

        while(twoNumbers != null) {
            System.out.println(twoNumbers.val);
            twoNumbers = twoNumbers.next;
        }

    }

    private static ListNode<Integer> addTwoNumbersV1(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode<Integer> result = new ListNode<>();
        ListNode<Integer> save;
        String num1 = "";
        String num2 = "";

        save = head1;
        while (save != null) {
            num1 = save.val + num1;
            save = save.next;
        }

        save = head2;
        while (save != null) {
            num2 = save.val + num2;
            save = save.next;
        }

        int sum = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());

        StringBuilder reverseSum = new StringBuilder(Integer.toString(sum)).reverse();
        save = result;
        for (int i : reverseSum.chars().toArray()) {
            save.next = new ListNode<>();
            num1 = (char)i + "";
            save.next.val = Integer.parseInt(num1);
            save = save.next;
        }

        return result.next;
    }

    private static ListNode<Integer> addTwoNumbersV2(ListNode<Integer> node1, ListNode<Integer> node2) {
        ListNode<Integer> root = new ListNode<>();
        ListNode<Integer> head = root;

        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int sum = 0;
            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }

            int val = sum % 10 + carry;
            carry = (sum + carry) / 10;
            head.next = new ListNode<>(val);
            head = head.next;
        }

        return root.next;
    }

}
