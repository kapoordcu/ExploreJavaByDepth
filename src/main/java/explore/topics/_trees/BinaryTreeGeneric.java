package explore.topics._trees;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class BinaryTreeGeneric<Key extends Comparable<Key>> {
    private static Node root;
    private static int max_level_left_View;
    private static int max_level_right_View;
    private static  Map<Integer, List<Integer>> hdVerticalOrder =  new TreeMap<>();
    private static  Map<Integer, Integer> hdBottomView =  new TreeMap<>();

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
     * Time Complexity of hashing based solution can be considered as O(n) under the assumption
     * that we have good hashing function that allows insertion and retrieval operations in O(1) time.
     * @param node
     */
    private void verticalOrderTraversalOfBinaryTree(Node node) {
        calculateHorizontalDistanceForVerticalOrder(node, 0);
        hdVerticalOrder.entrySet().stream()
                .forEach((entry -> System.out.println(entry.getValue())));

    }

    private void calculateHorizontalDistanceForVerticalOrder(Node node, int level) {
        if(node==null) {
            return;
        }
        List<Integer> nodes = hdVerticalOrder.get(level);
        if(nodes==null) {
            nodes = new ArrayList<>();
        }
        nodes.add((Integer) node.data);
        hdVerticalOrder.put(level, nodes);
        calculateHorizontalDistanceForVerticalOrder(node.left, level-1);
        calculateHorizontalDistanceForVerticalOrder(node.right, level+1);
    }

    /**
     * Left view of the tree
     */
    private void leftViewOfBinaryTree(Node node, int level) {
        if(node==null) {
            return;
        } else {
            if(level > max_level_left_View) {
                System.out.print(node.data + " ");
                max_level_left_View = level;
            }
            leftViewOfBinaryTree(node.left, level+1);
            leftViewOfBinaryTree(node.right, level+1);
        }
    }

    /**
     * Right view of the tree
     */
    private void rightViewOfBinaryTree(Node node, int level) {
        if(node==null) { return;}
        if(level>max_level_right_View) {
            System.out.print(node.data + " ");
            max_level_right_View = level;
        }
        rightViewOfBinaryTree(node.right, level + 1);
        rightViewOfBinaryTree(node.left, level + 1);
    }

    /**
     * Time Complexity: Worst case time complexity of the above method is O(n^2).
     * Worst case occurs in case of skewed trees.
     * @param node
     */
    private void levelOrderTravesalSpiral(Node node) {
        boolean leftToRight = true;
        int height = heightOfTree(node);
        for (int i = 1; i <=height ; i++) {
            printLevel(node, i, leftToRight);
            leftToRight = !leftToRight;
        }
    }

    /**
     * Time Complexity: Worst case time complexity of the above method is O(n^2).
     * Worst case occurs in case of skewed trees.
     * @param node
     */
    private void levelOrderTravesalSpiralOnOn(Node node) {
        Stack<Node> stackLR = new Stack<>();
        Stack<Node> stackRL = new Stack<>();
        stackLR.push(node);
        while (!stackLR.isEmpty() || !stackRL.isEmpty()) {
            while (!stackLR.isEmpty()) {
                Node pop = stackLR.pop();
                System.out.print(pop.data + " ");
                if (pop.left != null) {
                    stackRL.push(pop.left);
                }
                if (pop.right != null) {
                    stackRL.push(pop.right);
                }
            }

            while (!stackRL.isEmpty()) {
                Node pop = stackRL.pop();
                System.out.print(pop.data + " ");
                if (pop.right != null) {
                    stackLR.push(pop.right);
                }
                if (pop.left != null) {
                    stackLR.push(pop.left);
                }
            }
        }
    }

    private void printLevel(Node node, int level, boolean leftToRight) {
        if(node==null) {
            return;
        }
        if(level==1) {
            System.out.print(node.data + " ");
        }
        if(leftToRight) {
            printLevel(node.left, level-1, leftToRight);
            printLevel(node.right, level-1, leftToRight);
        } else {
            printLevel(node.right, level-1, leftToRight);
            printLevel(node.left, level-1, leftToRight);
        }
    }

    private int heightOfTree(Node node) {
        if(node==null) {
            return 0;
        }
        return Math.max(heightOfTree(node.left), heightOfTree(node.right)) + 1;
    }

    private void BottomViewOfBinaryTree(Node node) {
        calculateHorizontalDistanceForBottomView(node, 0);
        System.out.println(hdBottomView);
    }

    private void calculateHorizontalDistanceForBottomView(Node node, int hd) {
        if(node==null) {
            return;
        }
        hdBottomView.put(hd, (Integer) node.data);
        calculateHorizontalDistanceForBottomView(node.left, hd-1);
        calculateHorizontalDistanceForBottomView(node.right, hd+1);
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

        /**             10
         *       5          12
         *          8           13
         *        6   9
         *
         */
        BinaryTreeGeneric<Integer> treeL = new BinaryTreeGeneric<>();
//        treeL.root = new Node(10);
//        treeL.root.left = new Node(5);
//        treeL.root.left.right = new Node(8);
//        treeL.root.left.right.left = new Node(6);
//        treeL.root.left.right.right = new Node(9);
//        treeL.root.right = new Node(12);
//        treeL.root.right.right = new Node(13);
//        //treeL.levelOrderPrint(treeL.root);
//        treeL.leftViewOfBinaryTree(treeL.root, 1);
//        System.out.println();
//        treeL.rightViewOfBinaryTree(treeL.root, 1);
//        System.out.println();

        treeL.root = new Node(1);
        treeL.root.left = new Node(2);
        treeL.root.left.left = new Node(4);
        treeL.root.left.right = new Node(5);
        treeL.root.right = new Node(3);
        treeL.root.right.left = new Node(6);
        treeL.root.right.left.right = new Node(8);
        treeL.root.right.right = new Node(7);
        treeL.root.right.right.right = new Node(9);
        treeL.verticalOrderTraversalOfBinaryTree(treeL.root);
        treeL.BottomViewOfBinaryTree(treeL.root);
        System.out.println("Level order traverasal o(n^2)");
        treeL.levelOrderTravesalSpiral(root);
        System.out.println();
        System.out.println(" Level order traverasal o(n) and o(n)");
        treeL.levelOrderTravesalSpiralOnOn(root);

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
