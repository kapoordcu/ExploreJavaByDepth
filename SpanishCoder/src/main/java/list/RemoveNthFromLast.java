package list;

import org.junit.jupiter.api.Test;

import static list.ListNode.createList;
import static org.junit.Assert.assertTrue;

public class RemoveNthFromLast {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode start = head;
        ListNode nthNode = head;
        while (k < n) {
            start = start.next;
            k++;
        }
        while (start != null) {
            nthNode = nthNode.next;
            start = start.next;
        }

        return nthNode;
    }

    @Test
    public void test01() {
        int[] arr = {1,2,3,4,5};
        ListNode head = createList(arr);
        ListNode newHead = removeNthFromEnd(head, 2);
        assertTrue(newHead.val==4);
//        assertTrue(sizeOf(head)==arr.length);
//        assertTrue(sizeOf(newHead)==arr.length-1);
    }

    @Test
    public void test02() {
        int[] arr = {1,2};
        ListNode head = createList(arr);
        ListNode newHead = removeNthFromEnd(head, 1);
        assertTrue(newHead.val==2);
//        assertTrue(sizeOf(head)==arr.length);
//        assertTrue(sizeOf(newHead)==arr.length-1);
    }
}
