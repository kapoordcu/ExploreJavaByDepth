package explore.topics._codingproblmes2020;

import java.util.Objects;
import java.util.Optional;

public class ReverseLL {
    public static void main(String[] args) {
        LinkedListUtil lis = new LinkedListUtilImpl();
        Node head1 = new Node(10);
        Node a1 = new Node(5);
        Node a2 = new Node(9);
        Node a3 = new Node(2);
        Node a4 = new Node(8);
        head1.setNext(a1);
        a1.setNext(a2);
        a2.setNext(a3);
        a3.setNext(a4);

        Node head2 = new Node(101);
        Node b1 = new Node(132);
        Node b2 = new Node(207);

        head2.setNext(b1);
        b1.setNext(b2);


        System.out.println(lis.reverse(head1));
        System.out.println(lis.join(head1, head2));
//        System.out.println(lis.join(head2, head1));
//        System.out.println(lis.join(null, head1));
//        System.out.println(lis.join(head1, null));


    }
}

class LinkedListUtilImpl implements LinkedListUtil {

    public Node join(Node a, Node b) {
        Optional<Node> aOpt = Optional.ofNullable(a);
        Optional<Node> bOpt = Optional.ofNullable(b);
        return checkNullHeads(aOpt, bOpt);
    }

    private Node checkNullHeads(Optional<Node> aOpt, Optional<Node> bOpt) {
        if(!aOpt.isPresent()) {
            if(bOpt.isPresent()) {
                return bOpt.get();
            } else {
                return null;
            }
        } else {
            if(bOpt.isPresent()) {
                return iterateBothList(aOpt.get(), bOpt.get());
            } else {
                return aOpt.get();
            }
        }
    }

    private Node iterateBothList(Node a, Node b) {
        Node previous = null;
        Node current = a;
        Node next;
        while (current!=null) {
            next = current.getNext();
            current.setNext(next);
            previous=current;
        }
        previous.setNext(b);
        return a;
    }


    public Node reverse(Node a) {
        Node previous = null;
        Node current = a;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    public Node findLoop(Node a) {
        Node previous = null;

        return previous;
    }
}


class Node {

    private Integer value;
    private Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }
}

interface LinkedListUtil {
    /**
     * Given the heads of two lists, the method will join list a with list b and return the head of the resulting list.
     * @param headA
     * @param headB
     * @return the head of the new list
     */
    Node join(Node headA, Node headB);

    /**
     * Given the head of a list, the method will reverse the list and return the new head of the resulting list.
     * @param head
     * @return the head of the new list
     */
    Node reverse(Node head);
}