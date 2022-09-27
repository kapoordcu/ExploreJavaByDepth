package list;

public class ListNode {
      int val;
      ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
      }

      public static ListNode createList(int[] arr) {
            ListNode  head = null;
            ListNode  node = null;
            for (int i = 0; i < arr.length; i++) {
                  if(head==null) {
                        head = new ListNode(arr[i]);
                        node = head;
                  } else {
                        node.next = new ListNode(arr[i]);
                        node = node.next;
                  }
            }
            return head;
      }

      public static  int sizeOf(ListNode mergedK) {
            int size = 0;
            while (mergedK!=null) {
                  size++;
                  mergedK = mergedK.next;
            }
            return size;
      }

      public static boolean isSorted(ListNode head) {
            ListNode prev = head;
            ListNode node = head;
            while (node!=null) {
                  prev = node;
                  node = node.next;
                  if(node!= null && node.val < prev.val) {
                        return false;
                  }
            }
            return true;
      }
}