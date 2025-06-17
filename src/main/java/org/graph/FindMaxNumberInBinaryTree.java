package org.graph;

/**
 * Гоша повесил на стену гирлянду в виде бинарного дерева, в узлах которого находятся лампочки.
 * У каждой лампочки есть своя яркость. Уровень яркости лампочки соответствует числу, расположенному в узле дерева.
 * Помогите Гоше найти самую яркую лампочку в гирлянде, то есть такую, у которой яркость наибольшая.
 * Вход: корень дерева
 */
public class FindMaxNumberInBinaryTree {
    //Структура вершины дерева
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    //Решение при помощи рекурсии
    public static int treeSolution(Node head) {
        //Яркость лампочки
        int max = head.value;
        Node left = head.left;
        Node right = head.right;

        if (left != null) {
            int leftMax = treeSolution(left);
            if (leftMax > max ) {
                max = leftMax;
            }
        }

        if (right != null) {
            int rightMax = treeSolution(right);
            if ( rightMax > max) {
                max = rightMax;
            }
        }

        return max;
    }
}
