package org.graph;

//
public class MaxLengthPath543 {


    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return result;
        }
        getLength(root);
        return result;
    }

    public int getLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = getLength(root.left);
        int r = getLength(root.right);

        //Сумма глубин левого и правого поддерева для каждого узла
        result = Math.max(result, l + r);

        //Возвращаем максимально возможную глубину поддерева
        return 1 + Math.max(l, r);
    }
}
