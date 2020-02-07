package explore.topics._trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private static Queue<TreeNode> Q = new LinkedList<>();
    private static TreeNode root;

    static int max_level = 0;

    public BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree treeL = new BinaryTree();
        treeL.root = new TreeNode(10);
        treeL.root.left = new TreeNode(5);
        treeL.root.right = new TreeNode(12);
        treeL.root.right.right = new TreeNode(13);
        treeL.root.left.right = new TreeNode(8);
        treeL.root.left.right.left = new TreeNode(6);
        treeL.root.left.right.right = new TreeNode(9);

        treeL.levelOrderTraversalNaive(treeL.root);
    }
    //Level Order traversal is also known as Breadth-First Traversal since it traverses
    // all the nodes at each level before going to the next level (depth).

    //Time Complexity:
        // O(n^2) in worst case.
        // For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
        // So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).
    //Space Complexity:
        // O(n) in worst case.
        // For a skewed tree, printGivenLevel() uses O(n) space for call stack.
        // For a Balanced tree, call stack uses O(log n) space, (i.e., height of the balanced tree).
    private void levelOrderTraversalNaive(TreeNode node) {
        int height = heightOfTree(node);
        for (int i = 1; i <= height ; i++) {
            printLevel_N(node, i);
        }
    }

    private void printLevel_N(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(level==1) {
            System.out.print(node.value + " ");
        } else {
            printLevel_N(node.left, level -1);
            printLevel_N(node.right, level -1);
        }
    }

    private int heightOfTree(TreeNode node) {
        if(node==null) {
            return 0;
        } else {
            return Math.max(heightOfTree(node.left), heightOfTree(node.right)) + 1;
        }
    }


    private void insertInLevelOrder(int value) {
        insertInLevelOrder(root, value);
    }

    private void insertInLevelOrder(TreeNode node, int value) {
        if(node==null) {
            root = new TreeNode(value);
            Q.add(root);
        } else {
            while(!Q.isEmpty()) {
                TreeNode peek = Q.peek();
                TreeNode treeNode = new TreeNode(value);
                if(peek.left!=null && peek.right!=null) {
                    Q.poll();
                    continue;
                } else if(peek.left==null) {
                    peek.left = treeNode;
                    Q.add(treeNode);
                    break;
                } else if(peek.right==null) {
                    peek.right = treeNode;
                    Q.add(treeNode);
                    break;
                }
            }
        }
    }

    //Inorder Travel of BST sorts the elements
    private void inorder(TreeNode node) {
        if(node==null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public Integer value;

        public TreeNode(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }
}
