package list;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode mergedHead = null;
        while (list1!=null && list2 !=null) {
            if(list1.val<list2.val) {
                if(head==null) {
                    head = list1;
                    mergedHead = head;
                } else {
                    mergedHead.next = list1;
                }
                list1 = list1.next;
            } else {
                if(head==null) {
                    head = list2;
                    mergedHead = head;
                } else {
                    mergedHead.next = list2;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            while (list1 != null) {
                mergedHead.next = list1;
                list1 = list1.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {
                mergedHead.next = list2;
                list2 = list2.next;
            }
        }
        return head;
    }

    @Test
    public void test01() {
        ListNode head1 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        head1.next = l1;
        l1.next = l2;

        ListNode head2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head2.next = l3;
        l3.next = l4;

        ListNode mergeTwoLists = mergeTwoLists(head1, head2);
        assertTrue(mergeTwoLists==head1 || mergeTwoLists==head2);
    }
}
