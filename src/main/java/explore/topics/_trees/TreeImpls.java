package explore.topics._trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeImpls {
    private static Queue<TreeNode> Q = new LinkedList<>();
    private static TreeNode root;

    public TreeImpls() {
        this.root = null;
    }

    public static void main(String[] args) {
        TreeImpls bst = new TreeImpls();
        bst.insertBST(10);
        bst.insertBST(12);
        bst.insertBST(5);
        bst.insertBST(13);
        bst.insertBST(6);
        bst.insertBST(9);
        bst.insertBST(8);
        bst.inorder(root);

        System.out.println();
        
        TreeImpls binary = new TreeImpls();
        binary.insertBinaryTree(10);
        binary.insertBinaryTree(12);
        binary.insertBinaryTree(5);
        binary.insertBinaryTree(13);
        binary.insertBinaryTree(6);
        binary.insertBinaryTree(9);
        binary.insertBinaryTree(8);
        binary.inorder(root);

    }

    private void insertBinaryTree(int value) {
        insertBinaryTree(root, value);
    }

    private void insertBinaryTree(TreeNode node, int value) {
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

    private void insertBST(int value) {
        root = insertBST(root, value);
    }

    private TreeNode insertBST(TreeNode node, int value) {
        if(node==null) {
            node = new TreeNode(value);
        } else {
            if(value<node.value) {
                node.left = insertBST(node.left, value);
            } else if(value>node.value) {
                node.right = insertBST(node.right, value);
            } else {
                node.value = value;
            }
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
