package explore.topics._ds.trees;

import java.util.Queue;

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
//        System.out.println(bstString.floor("G"));
//        System.out.println(bstString.floor("D"));
//        System.out.println(bstString.ceil("Q"));
//        System.out.println(bstString.ceil("Q"));
        bstString.inorder();
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if(node==null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }

    public void insert(Key key) {
        root = insert(root, key);
    }

    private Node insert(Node node, Key key) {
        if(node==null) {
            return new Node(key);
        }
        int compareKey = key.compareTo(node.key);
        if(compareKey<0) {
            node.left = insert(node.left, key);
        } else if(compareKey>0) {
            node.right = insert(node.right, key);
        } else {
            node.key = key;
        }
        return node;
    }

    public Key floor(Key key) {
        return floor(root, key).key;
    }
    private Key ceil(Key key) {
        return ceil(root, key).key;
    }

    private Node ceil(Node node, Key key) {
        if(node==null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if(compare==0) {
            return node;
        } else if(compare<0) {
            return ceil(node.right, key);
        }
        Node smallest = ceil(node.left, key);
        if(smallest!=null) {
            return smallest;
        } else {
            return node;
        }
    }

    private Node floor(Node node, Key key) {
        if(node==null) {
            return null;
        }
        int compareTo = key.compareTo(node.key);
        if(compareTo==0) {
            return node;
        } else if(compareTo<0) {
            return floor(node.left, key);
        }
        Node highest = floor(node.right, key);
        if(highest!=null) {
            return highest;
        } else {
            return node;
        }
    }

}
