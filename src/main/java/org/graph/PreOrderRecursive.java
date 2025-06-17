package org.graph;

import java.util.ArrayList;
import java.util.List;
/** ПРЯМОЙ ТИП ОБХОДА
 * Обрабатываем узел когда приходим в него первый раз. После переходи к левому поддереву, потом к правому*/

public class PreOrderRecursive {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getPreorder(root, result);
        return result;
    }

    private void getPreorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        getPreorder(root.left, result);
        getPreorder(root.right, result);
    }
}
