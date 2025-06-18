package org.graph;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return getPath(root, targetSum);
    }

    public boolean getPath(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        //Дошли до конца пути
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        return getPath(root.left, targetSum - root.val) ||
                getPath(root.right, targetSum - root.val);
    }
}
