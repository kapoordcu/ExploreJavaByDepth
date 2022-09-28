package trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTree {
    TreeNode root;
    public TreeNode createBinaryTree(Integer[] arr, int i) {
        TreeNode node = null;
        if(i < arr.length) {
            node = new TreeNode(arr[i]);
            node.left = createBinaryTree(arr, 2*i+1);
            node.right = createBinaryTree(arr, 2*i+2);
        }
        return node;
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode root1 = createUnbalancedTree(8);
        int maxDepth = maxDepth(root1);
        assertTrue(maxDepth==4);

        TreeNode root2 = createSmallestTree();
        int maxDepth2 = maxDepth(root2);
        assertTrue(maxDepth2==1);
    }

    @Test
    public void testSameTree() {
        TreeNode root1 = createUnbalancedTree(8);
        TreeNode root2 = createSmallestTree();
        TreeNode root3 = createUnbalancedTree(8);
        TreeNode root4 = createSmallestTree();
        assertFalse(isSameTree(root1, root2));
        assertTrue(isSameTree(root1, root3));
        assertTrue(isSameTree(root2, root4));
    }

    @Test
    public void testSameTreeNot() {
        TreeNode root1 = createUnbalancedTree(8);
        TreeNode root2 = createUnbalancedTree(2);
        assertFalse(isSameTree(root1, root2));
    }


    /*
                                8
                        4               5
                2               1
                                        6
     */
    private TreeNode createUnbalancedTree(int rootValue) {
        TreeNode root = new TreeNode(rootValue);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        return root;
    }

    private TreeNode createSmallestTree() {
        TreeNode root = new TreeNode(8);
        return root;
    }

    //Maximum Depth of Binary Tree
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth((root.right))) + 1;
    }

    //Same Tree -
    // https://leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p!=null && q!=null &&
                p.val==q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right))  return true;
        return false;
    }

    //Invert/Flip Binary Tree -
    // https://leetcode.com/problems/invert-binary-tree/ 
    public TreeNode invertTree(TreeNode root) {
        return null;
    }

    //Binary Tree Maximum Path Sum -
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/
    public int maxPathSum(TreeNode root) {
        return 0;
    }

    //- Binary Tree Level Order Traversal -
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    // Serialize and Deserialize Binary Tree -
    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public String serialize(TreeNode root) {
        return null;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    // Subtree of Another Tree -
    // https://leetcode.com/problems/subtree-of-another-tree/
    // Encodes a tree to a single string.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return false;
    }

    // Construct Binary Tree from Preorder and Inorder Traversal -
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public void inOrder(TreeNode root) {
        if(root!=null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    @Test
    public void testInorder() {
        TreeNode root = createUnbalancedTree(12);
        inOrder(root);
    }
}


