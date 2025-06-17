package org.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderStack {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            //Спуск по левым поддеревьям
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //Возращение в центр
            root = stack.pop();
            result.add(root.val);

            //Переход к правому поддереву
            root = root.right;

        }
        return result;
    }
}
