package explore.topics._ds.trees;

public class BSTOps<Key extends Comparable<Key>> {
    private Node root;

    public BSTOps() {
        this.root = null;
    }

    private class Node {
        private Key key;
        private Node left;
        private Node right;

        public Node(Key key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BSTOps<String> bstString = new BSTOps();
        bstString.insert("S");
        bstString.insert("E");
        bstString.insert("X");
        bstString.insert("A");
        bstString.insert("R");
        bstString.insert("C");
        bstString.insert("H");
        bstString.insert("M");
    }

    public void insert(Key key) {
        root = insert(root, key);
    }

    public Node insert(Node current, Key key) {
        if(current==null) {
            return new Node(key);
        }
        int comp = key.compareTo(current.key);
        if(comp<0) {
            current.left = insert(current.left, key);
        } else if(comp>0) {
            current.right = insert(current.right, key);
        } else {
            current.key = key;
        }
        return current;
    }
}
