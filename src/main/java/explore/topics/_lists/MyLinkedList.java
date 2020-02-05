package explore.topics._lists;

public class MyLinkedList {
    public Node head;

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
    }

    public void insert(Integer key) {
        Node newNode = new Node(key);
        Node temp;
        if(head==null) {
            head = newNode;
        } else {
            temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void findMiddle(){
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
        if(fast==null) {
            System.out.println(slow.next.data);
        }
    }

    public void reverseList() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private Node reverseListInGroupOfSizeK(MyLinkedList list, Node node, int K) {
        int i = 0;
        int findNextHead = 0;
        Node current = node;
        Node next = null;
        Node prev = null;
        while (i++<K && current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if(next!=null) {
            node.next = reverseListInGroupOfSizeK(list, next, K);
            if(findNextHead++==0) {
                list.head = prev;
            }
        }
        return prev;
    }

    private void rotateList(MyLinkedList list, int rotations) {
        Node start = list.head;
        int i = 0;
        while(i++ != rotations-1) {
            start = start.next;
        }
        Node end = start;
        while (end.next!=null) {
            end = end.next;
        }
        end.next = list.head;
        list.head = start.next;
        start.next = null;
    }

    private static void printList(MyLinkedList list) {
        Node start = list.head;
        while(start!=null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.insert(12);
        list.insert(3);
        list.insert(7);
        list.insert(2);
        list.insert(8);
        list.insert(9);
        list.insert(2);
        list.insert(90);
        list.insert(11);
        list.insert(16);
//
//        //Finding middle element in a linked list
//        System.out.println("Finding findMiddle");
//        list.findMiddle();
//
//        //Reverse a linked list
//        System.out.println("Before calling reverseList");
//        printList(list);
//        list.reverseList();
//        System.out.println();
//        System.out.println("After calling reverseList");
//        printList(list);

//        //Rotate a Linked List
//        System.out.println("Before calling rotateList");
//        printList(list);
//        list.rotateList(list, 4);
//        System.out.println();
//        System.out.println("After calling rotateList");
//        printList(list);
        
        //Reverse a Linked List in groups of given size
        System.out.println("Before calling reverseListInGroupOfSizeK");
        printList(list);
        list.reverseListInGroupOfSizeK(list, list.head, 2);
        System.out.println();
        System.out.println("After calling reverseListInGroupOfSizeK");
        printList(list);
    }
}