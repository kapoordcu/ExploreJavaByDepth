package list;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static list.ListNode.*;
import static org.junit.Assert.assertTrue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode mergedHead = dummy;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode head: lists) {
            while (head!=null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        while (!minHeap.isEmpty()) {
            mergedHead.next = new ListNode(minHeap.remove());
            mergedHead = mergedHead.next;
        }
        return dummy.next;
    }

    @Test
    public void test01() {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1,3,4};
        int[] arr3 = {2,6};
        ListNode head1 = createList(arr1);
        ListNode head2 = createList(arr2);
        ListNode head3 = createList(arr3);
        ListNode[] lists = {head2, head1, head3};
        ListNode mergedHead = mergeKLists(lists);
        int sizeMerged = sizeOf(mergedHead);
        assertTrue(sizeMerged==arr1.length+arr2.length+ arr3.length);
        assertTrue(sizeOf(head1)==arr1.length);
        assertTrue(sizeOf(head2)==arr2.length);
        assertTrue(sizeOf(head3)==arr3.length);
        assertTrue(isSorted(head1));
        assertTrue(isSorted(head2));
        assertTrue(isSorted(head3));
        assertTrue(isSorted(mergedHead));
    }

}
