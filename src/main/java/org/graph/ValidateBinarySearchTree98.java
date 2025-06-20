package org.graph;

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return getResult(root.left, Long.MIN_VALUE, root.val) &&
                getResult(root.right, root.val, Long.MAX_VALUE);
    }

    public boolean getResult(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val < max && root.val > min) {
            return getResult(root.left, min, root.val) &&
                    getResult(root.right, root.val, max);
        }
        return false;
    }
}
