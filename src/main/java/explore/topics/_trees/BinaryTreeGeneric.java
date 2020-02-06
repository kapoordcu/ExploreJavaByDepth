package explore.topics._trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeGeneric<Key extends Comparable<Key>> {
    private static Node root;

    /**
     * Check BST
     * Time Complexity: O(n)
     * Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
     */
    private boolean isBST(Node node, Node l, Node r) {
        if(node==null) {
            return true;
        }

        if((r!=null && r.data.compareTo(node.data) < 0) || (l!=null && node.data.compareTo(l.data) < 0)) {
            return false;
        }
        return isBST(node.left, l, node) &&
                isBST(node.right, node, r);
    }

    /**
     * Level order traversal
     * Time Complexity: O(n) where n is number of nodes in the binary tree
     * Space Complexity: O(n) where n is number of nodes in the binary tree
     */
    private void levelOrderPrint(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.data + " ");
            if(poll.left!=null) {
                queue.add(poll.left);
            }
            if(poll.right!=null) {
                queue.add(poll.right);
            }
        }
    }

    public static void main(String[] args) {

        BinaryTreeGeneric<String> treeL = new BinaryTreeGeneric<>();
        treeL.root = new Node("a");
        treeL.root.left = new Node("b");
        treeL.root.left.left = new Node("d");
        treeL.root.left.left.left = new Node("h");
        treeL.root.left.left.right = new Node("i");
        treeL.root.left.right = new Node("e");
        treeL.root.right = new Node("c");
        treeL.root.right.left = new Node("f");
        treeL.root.right.right = new Node("g");
        treeL.root.right.right.left = new Node("j");
        treeL.root.right.right.right = new Node("k");


        treeL.levelOrderPrint(treeL.root);

//        BinaryTreeGeneric<String> notBST = new BinaryTreeGeneric<>();
//        notBST.root = new Node("a");
//        notBST.root.left = new Node("b");
//        notBST.root.left.left = new Node("d");
//        notBST.root.left.left.left = new Node("h");
//        notBST.root.left.left.right = new Node("i");
//        notBST.root.left.right = new Node("e");
//        notBST.root.right = new Node("c");
//        notBST.root.right.left = new Node("f");
//        notBST.root.right.right = new Node("g");
//        notBST.root.right.right.left = new Node("j");
//        notBST.root.right.right.right = new Node("k");
//        System.out.println(notBST.isBST(notBST.root, null, null));
//        BinaryTreeGeneric<String> BST = new BinaryTreeGeneric<>();
//        BST.root = new Node("f");
//        BST.root.left = new Node("d");
//        BST.root.left.left = new Node("b");
//        BST.root.left.left.left = new Node("a");
//        BST.root.left.left.right = new Node("c");
//        BST.root.left.right = new Node("e");
//        BST.root.right = new Node("h");
//        BST.root.right.left = new Node("g");
//        BST.root.right.right = new Node("j");
//        BST.root.right.right.left = new Node("i");
//        BST.root.right.right.right = new Node("k");
//        System.out.println(BST.isBST(BST.root, null, null));
    }

    static class Node {
        public Comparable data;
        public Node left;
        public Node right;

        public Node(Comparable data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
