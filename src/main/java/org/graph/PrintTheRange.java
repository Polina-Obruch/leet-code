package org.graph;

import java.io.BufferedWriter;
import java.io.IOException;

//Вывести значения узлов бинарного дерева в неубывающем порядке из заданного диапазона [L,R]
public class PrintTheRange {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void printRange(Node root, int L, int R, BufferedWriter writer) throws IOException {
        if ( root == null) {
            return;
        }

        int value = root.getValue();

        //Нахождение минимально подходящего
        if (value >= L) {
            printRange(root.getLeft(), L, R, writer);
        }

        //Вывод центрального узла
        if (value >= L && value <= R) {
            writer.write(String.valueOf(value));
            writer.write("\n");
        }

        //Поиск максимально подходящего
        if (value <= R) {
            printRange(root.getRight(),L, R, writer);
        }
    }
}
