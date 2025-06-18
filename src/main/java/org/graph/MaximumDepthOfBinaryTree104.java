package org.graph;

import java.util.LinkedList;
import java.util.Queue;


public class MaximumDepthOfBinaryTree104 {
    //DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBFS(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            max += 1;
            int level = queue.size();

            for (int i = 0; i < level; ++i) {
                TreeNode current = queue.poll();

                if (current.right != null) {
                    queue.add(current.right);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
            }
        }
        return max;
    }



//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return getMaxDepth(root, 0);
//    }
//
//    public int getMaxDepth(TreeNode root, int dpt) {
//        if (root == null) {
//            return dpt;
//        }
//
//        ++dpt;
//
//        return Math.max(getMaxDepth(root.left, dpt), getMaxDepth(root.right, dpt));
//    }
}
