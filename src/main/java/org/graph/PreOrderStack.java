package org.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderStack {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                result.add(current.val);
                stack.push(current.right);
                stack.push(current.left);
            }
        }
        return result;
    }

}
