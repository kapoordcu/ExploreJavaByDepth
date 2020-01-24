package explore.topics._ds.trees;

public class BST<Key extends Comparable<Key>, Value> {

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(10, "G");
        bst.put(8, "K");
        bst.put(3, "U");
        bst.put(5, "S");
        bst.put(6, "A");
        bst.put(2, "K");

        System.out.println(bst.get(5));
        System.out.println(bst.get(12));
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());

    }
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if(node==null) {
            return new Node(key, value);
        }
        int comp = key.compareTo(node.key);
        if(comp<0) {
            node.left = put(node.left, key, value);
        } else if(comp>0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        Node current = root;
        while(current!=null) {
            int less = key.compareTo(current.key);
            if(less < 0) {
                current = current.left;
            } else if(less>0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }

    public Value getMin() {
        Node current = root;
        while(current.left!=null) {
            current=current.left;
        }
        return current.value;
    }

    public Value getMax() {
        Node current = root;
        while(current.right!=null) {
            current=current.right;
        }
        return current.value;
    }
}


