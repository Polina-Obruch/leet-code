package org.graph;

import java.util.ArrayList;
import java.util.List;

public class PostOrderRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        getPostOrder(root, result);

        return result;
    }

    public void getPostOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        getPostOrder(root.left, result);
        getPostOrder(root.right, result);
        result.add(root.val);
    }
}
