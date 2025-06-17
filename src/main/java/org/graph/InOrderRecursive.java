package org.graph;

import java.util.ArrayList;
import java.util.List;

public class InOrderRecursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getInorder(root, result);
        return result;
    }

    public void getInorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        getInorder(root.left, result);
        result.add(root.val);
        getInorder(root.right, result);
    }
}
