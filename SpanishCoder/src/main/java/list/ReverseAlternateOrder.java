package list;

public class ReverseAlternateOrder {

    public void reorderList(ListNode head) {
        ListNode midNode = findUsingSlowAndFastPointer(head);
        ListNode reverse = ReverseList.reverseList(midNode.next);
        ListNode reordered = mergeTwoLists(head, reverse);
    }

    private ListNode mergeTwoLists(ListNode head, ListNode reverse) {
        ListNode newHead = null;
        int i = 0;
        while (head != null || reverse!=null) {

        }
        return null;
    }

    private ListNode findUsingSlowAndFastPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
