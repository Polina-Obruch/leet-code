package org.graph;


import java.util.Stack;

public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, 0, false);
    }

    //DFS рекурсивно
    public int getSum(TreeNode root, int sum, boolean isLeft) {

        if (root == null) {
            return sum;
        }

        if (isLeft && root.left == null && root.right == null) {
            return sum += root.val;
        }

        return getSum(root.left, sum, true) + getSum(root.right, sum, false);
    }

    //DFS
    public int sumOfLeftLeavesTWO(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null && current.left.left == null && current.left.right == null) {
                sum += current.left.val;
                continue;
            }

            if (current.left != null) {
                stack.push(current.left);
            }

        }

        return sum;
    }

}
