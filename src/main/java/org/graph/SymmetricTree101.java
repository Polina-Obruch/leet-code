package org.graph;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getResult(root.left, root.right);
    }

    public boolean getResult(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }

        if (L != null && R != null && L.val == R.val) {
            return getResult(L.right, R.left) && getResult(L.left, R.right);
        }

        return false;
    }
}
