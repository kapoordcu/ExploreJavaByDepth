package list;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void traverseList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    @Test
    public void test01() {
        ListNode head = new ListNode(10);
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(13);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(4);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode reverseList = reverseList(head);
        assertTrue(reverseList.val==4);
        assertTrue(reverseList.next==l3);
    }
}
