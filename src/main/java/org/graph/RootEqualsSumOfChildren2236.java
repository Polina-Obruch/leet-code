package org.graph;

/**
 You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.
 Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.
 */
public class RootEqualsSumOfChildren2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
