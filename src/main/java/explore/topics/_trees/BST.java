package explore.topics._trees;

import explore.topics._arrays.LeaderInArray;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private static Queue<TreeNode> Q = new LinkedList<>();
    private static TreeNode root;

    public BST() {
        this.root = null;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertBST(8);
        bst.insertBST(9);
        bst.insertBST(2);
        bst.insertBST(4);
        bst.insertBST(7);
        bst.insertBST(6);
        bst.insertBST(1);
        bst.insertBST(3);
        bst.insertBST(5);
        bst.preorder(root);
        System.out.println();
        System.out.println("Lowest Common Ancestor: " + bst.LowestCommonAncestor(root, 3, 7));
        System.out.println("Lowest Common Ancestor: " + bst.LowestCommonAncestor(root, 6, 7));
        System.out.println("Lowest Common Ancestor: " + bst.LowestCommonAncestor(root, 4, 5));
        System.out.println("Lowest Common Ancestor: " + bst.LowestCommonAncestor(root, 4, 3));
        System.out.println("Lowest Common Ancestor: " + bst.LowestCommonAncestor(root, 1, 7));
    }

    private void preorder(TreeNode node) {
        if(node==null) {
            return;
        }
        preorder(node.left);
        System.out.print(node.value + " ");
        preorder(node.right);
    }

    /**
     * Lowest Common Ancestor in a BST
     */
    private int LowestCommonAncestor(TreeNode node, int a, int b) {
        if(node==null) {
            return -1;
        }
        if(a<node.value && b < node.value) {
            return LowestCommonAncestor(node.left, a, b);
        } else if(a>node.value && b > node.value) {
            return LowestCommonAncestor(node.right, a, b);
        } else if(a>node.value && b < node.value) {
            return node.value;
        } else if(a<node.value && b>node.value) {
            return node.value;
        } else if(node.value==a || node.value==b){
            return node.value;
        }
        return -1;
    }

    private void insertBST(int value) {
        root = insertBST(root, value);
    }

    private TreeNode insertBST(TreeNode node, int value) {
        if(node==null) {
            node = new TreeNode(value);
        } else if(value<node.value) {
                node.left = insertBST(node.left, value);
        } else if(value>node.value) {
                node.right = insertBST(node.right, value);
        } else {
                node.value = value;
        }
        return node;
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
