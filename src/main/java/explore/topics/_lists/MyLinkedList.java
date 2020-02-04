package explore.topics._lists;

public class MyLinkedList {
    public static void main(String[] args) {
        MyList  list = new MyList();
        list.insert(12);
        list.insert(3);
        list.insert(7);
        list.insert(2);
        list.insert(8);
        list.insert(9);
        list.insert(2);
        list.insert(90);
        list.insert(11);

//        list.findMiddle();
//        list.reverseList();
//        printList(list);
        rotateList(list, 4);

    }

    private static void rotateList(MyList list, int rotations) {
        
    }

    private static void printList(MyList list) {
        MyListNode start = list.head;
        while(start!=null) {
            System.out.println(start.value);
            start = start.next;
        }
    }
}

class MyListNode<Key extends Comparable<Key>> {
    public Key value;
    public MyListNode next;

    public MyListNode(Key value) {
        this.value = value;
        this.next = null;
    }
}

class MyList {
    public MyListNode head;
    public Integer size;

    public MyList() {
        this.head = null;
        this.size = 0;
    }

    public void insert(Object key) {
        MyListNode newNode = new MyListNode((Comparable) key);
        MyListNode temp;
        if(head==null) {
            head = newNode;
            size++;
        } else {
            temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
        }

    }

    public void findMiddle(){
        MyListNode slow = head;
        MyListNode fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);
        if(size%2==0) {
            System.out.println(slow.next.value);
        }
    }

    public void reverseList() {
        MyListNode current = head;
        MyListNode prev = null;
        MyListNode next = null;
        while (current!=null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;

        }
        head = prev;
    }
}