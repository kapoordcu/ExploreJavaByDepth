package ds.own.my;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class BSTfromArray<K> {
    private TreeNode root;

    public BSTfromArray() {}

    public void init(int[] insertionArray) {
        for (Integer elem: insertionArray) {
            add(elem);
        }
    }

    @Test
    public void testFirstTree() {
        List<Integer> inOrderList = new ArrayList<>();
        BSTfromArray<Integer> bst = new BSTfromArray<>();

        int[] insertionArray = {6, 11, 8, 3, 5, 4, 13, 12};
        bst.init(insertionArray);
        inOrderTraversal(bst.root, inOrderList);
        assertTrue(inOrderList.get(0)== IntStream.of(insertionArray).min().getAsInt());
        assertTrue(inOrderList.get(inOrderList.size()-1)==IntStream.of(insertionArray).max().getAsInt());
        assertTrue(inOrderList.size()==insertionArray.length);
    }

    @Test
    public void testSecondTree() {
        List<Integer> inOrderList = new ArrayList<>();
        BSTfromArray<Integer> bst = new BSTfromArray<>();

        int[] insertionArray = {7, 1, 11, 6, 9, 12, 3};
        bst.init(insertionArray);
        inOrderTraversal(bst.root, inOrderList);
        assertTrue(inOrderList.get(0) == IntStream.of(insertionArray).min().getAsInt());
        assertTrue(inOrderList.get(inOrderList.size() - 1) == IntStream.of(insertionArray).max().getAsInt());
        assertTrue(inOrderList.size() == insertionArray.length);
    }

    private boolean isSymmetric(TreeNode root) {
        return false;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> inOrderList) {
        if(node.leftChild!=null) {
            inOrderTraversal(node.leftChild, inOrderList);
        }
        if(node!=null) {
            inOrderList.add(node.value);
        }
        if(node.rightChild!=null) {
            inOrderTraversal(node.rightChild, inOrderList);
        }
    }

    private int findDepth(BSTfromArray<Integer> bst) {
        return 0;
    }

    private void add(int value) {
        root = addNode(root, value);
    }

    private TreeNode addNode(TreeNode node, int value) {
        if(node==null) {
            node = new TreeNode(value);
        } else if(value<node.value) {
            node.leftChild = addNode(node.leftChild, value);
        } else if(value>node.value) {
            node.rightChild = addNode(node.rightChild, value);
        } else {
            node.value = value;
        }
        return node;
    }
}

class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int value) {
        this.value = value;
    }
}
