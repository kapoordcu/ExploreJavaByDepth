package list;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetectCycleInLL {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                return true;
            }
        }
        return false;
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
        l4.next = l2;

        assertTrue(hasCycle(head));
        l4.next = null;
        assertFalse(hasCycle(head));
    }
}
