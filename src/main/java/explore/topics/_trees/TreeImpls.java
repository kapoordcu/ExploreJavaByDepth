package explore.topics._trees;

public class TreeImpls {

    private static TreeNode root;

    public TreeImpls() {
        this.root = null;
    }

    public static void main(String[] args) {
        TreeImpls tree = new TreeImpls();
//        tree.insertBST(10);
//        tree.insertBST(12);
//        tree.insertBST(5);
//        tree.insertBST(13);
//        tree.insertBST(6);
//        tree.insertBST(9);
//        tree.insertBST(8);
//        tree.inorderBST(root);

        tree.insertBinaryTree(10);
        tree.insertBinaryTree(12);
        tree.insertBinaryTree(5);
        tree.insertBinaryTree(13);
        tree.insertBinaryTree(6);
        tree.insertBinaryTree(9);
        tree.insertBinaryTree(8);

    }

    private void insertBinaryTree(int value) {
        root = insertBinaryTree(root, value);
    }

    private TreeNode insertBinaryTree(TreeNode node, int value) {
        return null;
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
    private void inorderBST(TreeNode node) {
        if(node==null) {
            return;
        }
        inorderBST(node.left);
        System.out.println(node.value);
        inorderBST(node.right);
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
