package Entity;

import java.util.Comparator;

public class BinaryTree<T> {
        private Node<T> root;

        public void insert(T data, Comparator<T> comparator) {
            root = insertRecursive(root, data, comparator);
        }

        private Node<T> insertRecursive(Node<T> currentNode, T data, Comparator<T> comparator) {

            if (currentNode == null) {
                return new Node<>(data);
            }


            int compareResult = comparator.compare(data, currentNode.data);


            if (compareResult < 0) {
                currentNode.left = insertRecursive(currentNode.left, data, comparator);
            }

            else if (compareResult >= 0) {
                currentNode.right = insertRecursive(currentNode.right, data, comparator);
            }

            return currentNode;
        }

        public T search(T key, Comparator<T> comparator) {
            return searchRecursive(root, key, comparator);
        }

        private T searchRecursive(Node<T> currentNode, T key, Comparator<T> comparator) {

            if (currentNode == null || comparator.compare(key, currentNode.data) == 0) {
                return (currentNode != null) ? currentNode.data : null;
            }

            int compareResult = comparator.compare(key, currentNode.data);

            if (compareResult < 0) {
                return searchRecursive(currentNode.left, key, comparator);
            }
            else if (compareResult > 0) {
                return searchRecursive(currentNode.right, key, comparator);
            }

            return null;
        }
    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
