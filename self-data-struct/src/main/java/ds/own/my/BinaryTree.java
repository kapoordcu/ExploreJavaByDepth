package ds.own.my;

import org.junit.Test;

public class BinaryTree {
    private BinaryNode root;

    public BinaryNode insertNode(BinaryNode node) {
        if(root==null) {
            return root;
        } else if(root.left==null) {
            return insertNode(node.left);
        } else if(root.left==null) {
            return insertNode(node.right);
        }
        return null;
    }

    @Test
    public void nodeInsert() {
        int[] array = {1,2,3,4,5,6,7,8, 9};
        addFromArray(array);
    }

    private void addFromArray(int[] array) {
        for (int elem: array) {
            root = addNode(root, elem);
        }
    }

    private BinaryNode addNode(BinaryNode node, int data) {
        if (node == null) {
            node = new BinaryNode(data);
        } else {
            if (node.left == null) {
                node.left = addNode(node.left, data);
            } else  if (node.right == null){
                node.right = addNode(node.right, data);
            } else {
                node.left.left = addNode(node.left.left, data);
                node.left.right = addNode(node.left.right, data);
            }
        }
        return node;
    }
}



class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }
}
