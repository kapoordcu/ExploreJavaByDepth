package trees;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root != null ) {
            int nodeValue = root.val;

            if(targetSum < nodeValue) {
                return false;
            }

            if(targetSum==nodeValue && root.left == null && root.right==null) {
                return true;
            }

            targetSum -= nodeValue;
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }
        return false;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(11);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(1);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        assertTrue(hasPathSum(root, 21));
        assertFalse(hasPathSum(root, 1));
        assertFalse(hasPathSum(root, 16));
        assertTrue(hasPathSum(root, 17));
    }
}
