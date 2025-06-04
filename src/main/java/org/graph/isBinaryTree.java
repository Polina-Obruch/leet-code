package org.graph;

/**
 * Гоша понял, что такое дерево поиска, и захотел написать функцию, которая определяет, является ли заданное дерево деревом поиска.
 * Значения в левом поддереве должны быть строго меньше, в правом —- строго больше значения в узле.
 */
public class isBinaryTree {
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

    public static boolean isBinaryTree(Node head) {
        return checkTree(head.left, Integer.MIN_VALUE, head.value)
                && checkTree(head.right, head.value, Integer.MAX_VALUE);
    }

    //Задаем диапазон в котором должны лежать вершины каждого поддерева
    private static boolean checkTree(Node head, int min, int max) {
        if (head == null) {
            return true;
        }

        if (head.value >= max || head.value <= min) {
            return false;
        }

        return checkTree(head.left, min, head.value)
                && checkTree(head.right, head.value, max);
    }
}
