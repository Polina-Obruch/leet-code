package org.graph;

/** ПРИНЦИП РАБОТЫ
 Удаление вершины из двоичного бинарного дерева можно разбить на 3 основных варианта:
 1) Удаление листового узла - в узле предка необходимо обнулить ссылку на удаляемый элемент
 2) Удаление узла с одним дочерним элементом - копируем дочерний узел в узел родителя удаляемого элемента
 3) Удаление узла с обоими дочерними элементами
 В этом случаи необходимо найти заменяющий элемент.
 newNode - самая правая вершина в левом поддереве удаляемого узла, которая заменит удаляемый элемент.
 У newNode может быть левый дочерний элемент, который необходимо присоединить к родителю newNode.
 **/
public class RemoveNodeInBST {
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

    public static Node remove(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (root.getValue() > key) {
            root.setLeft(remove(root.getLeft(), key));
        } else if (root.getValue() < key) {
            root.setRight(remove(root.getRight(), key));
        } else {
            //Нашли удаляемый элемент
            Node left = root.getLeft();
            Node right = root.getRight();
            Node currentParents = root;
            Node newRoot = currentParents.getLeft();

            //Если есть только один дочерний элемент или оба null
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }

            //Находим заменяющий элемент
            while (newRoot.getRight() != null) {
                currentParents = newRoot;
                newRoot = newRoot.getRight();
            }

            if (!root.equals(currentParents)) {
                currentParents.setRight(newRoot.getLeft());
                newRoot.setLeft(left);
            }

            newRoot.setRight(right);
            return newRoot;
        }

        return root;
    }
}
