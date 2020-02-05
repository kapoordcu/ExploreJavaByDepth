package explore.topics._lists;

public class MyLinkedListPart2 {
    public static Node head;

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public MyLinkedListPart2() {
        this.head = null;
    }

    public static void main(String[] args) {
        MyLinkedListPart2 list1 = new MyLinkedListPart2();
        MyLinkedListPart2 list2 = new MyLinkedListPart2();
        // creating first linked list
        list1.head = new Node(3);
        list1.head.next = new Node(6);
        list1.head.next.next = new Node(9);
        list1.head.next.next.next = new Node(15);
        list1.head.next.next.next.next = new Node(30);
        // creating second linked list
        list2.head = new Node(10);
        list2.head.next = new Node(15);
        list2.head.next.next = new Node(30);

        System.out.println(findIntersection(list1.head, list2.head));
    }

    private static int findIntersection(Node head1, Node head2) {
        return 0;
    }
}
