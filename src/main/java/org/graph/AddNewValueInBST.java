package org.graph;

public class AddNewValueInBST {
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

    public static Node addNode(Node root, int key) {

        //Когда нашли позицию
        if (root == null) {
            return new Node(null, null, key);
        }

        if (root.getValue() > key) {
            root.setLeft(addNode(root.getLeft(), key));
        } else {
            root.setRight(addNode(root.getRight(), key));
        }

        return root;
    }
}
