package com.thealgorithms.datastructures.trees;

import java.util.Queue;
import java.util.LinkedList;

/**
 * This entire class is used to build a Binary Tree data structure. There is the
 * Node Class and the Tree Class, both explained below.
 */
/**
 * A binary tree is a data structure in which an element has two
 * successors(children). The left child is usually smaller than the parent, and
 * the right child is usually bigger.
 *
 * @author Unknown
 */
public class BinaryTree {

    /**
     * This class implements the nodes that will go on the Binary Tree. They
     * consist of the data in them, the node to the left, the node to the right,
     * and the parent from which they came from.
     *
     * @author Unknown
     */
    static class Node {

        /**
         * Data for the node
         */
        public int data;
        /**
         * The Node to the left of this one
         */
        public Node left;
        /**
         * The Node to the right of this one
         */
        public Node right;
        /**
         * The parent of this node
         */
        public Node parent;

        /**
         * Constructor of Node
         *
         * @param value Value to put in the node
         */
        public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    /**
     * The root of the Binary Tree
     */
    private Node root;

    /**
     * Constructor
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Parameterized Constructor
     */
    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * Method to find a Node with a certain value
     *
     * @param key Value being looked for
     * @return The node if it finds it, otherwise returns the parent
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null) {
                    return current; // The key isn't exist, returns the parent
                }
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null) {
                    return current;
                }
                current = current.right;
            } else { // If you find the value return it
                return current;
            }
        }
        return null;
    }

    /**
     * Inserts certain value into the Binary Tree
     *
     * @param value Value to be inserted
     */
    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            // This will return the soon to be parent of the value you're inserting
            Node parent = find(value);

            // This if/else assigns the new node to be either the left or right child of the parent
            if (value < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }
    }

    /**
     * Deletes a given value from the Binary Tree
     *
     * @param value Value to be deleted
     * @return If the value was deleted
     */
    public boolean remove(int value) {
        // Using the refactored remove algorithm we actually need to
        // do an additional check to see if the node we want to remove exists.
        // This will increase runtime.
        if (!contains(value)) {
            return false;
        }

        root = remove(value, root);

        return true;
    }

    // Recursively deletes a node from the tree.
    private Node remove(int value, Node node) {
        // The node does not exist.
        if (node == null) {
            return null;
        }

        if (value < node.data) {
            node.left = remove(value, node.left);
        } else if (value > node.data) {
            node.right = remove(value, node.right);
        } else {
            // If the node to remove only has one child we can let the child be the successor.
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            // If the node to remove has two children we should delete the min node in the right sub-tree
            // and let that node be the successor.

            // Keep a temporary reference to the node that should be removed.
            Node temp = node;

            // Find the successor in the right sub-tree.
            node = findSuccessor(temp);

            // Remove the successor node from the right sub-tree and set up the correct left and right links.
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }

        return node;
    }

    /**
     * Deletes the minimum node in the tree.
     *
     * @param node the root of the tree.
     * @return a tree where the minimum node is deleted.
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = removeMin(node.left);

        return node;
    }

    /**
     * Returns true if the binary tree contains the key otherwise false.
     * This method was needed in order to write the unit-tests because the
     * existing find method returns the parent of a node if it does not exist.
     *
     * @param key The key to search for.
     * @return true if the key is found, otherwise false.
     */
    public boolean contains(int key) {
        Node current = root;

        while (current != null) {
            if (key < current.data) {
                current = current.left;
            } else if (key > current.data) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * This method finds the Successor to the Node given. Move right once and go
     * left down the tree as far as you can
     *
     * @param n Node that you want to find the Successor of
     * @return The Successor of the node
     */
    public Node findSuccessor(Node n) {
        if (n.right == null) {
            return n;
        }
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    /**
     * Returns the root of the Binary Tree
     *
     * @return the root of the Binary Tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Prints leftChild - root - rightChild This is the equivalent of a depth
     * first search
     *
     * @param localRoot The local root of the binary tree
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    /**
     * Prints root - leftChild - rightChild
     *
     * @param localRoot The local root of the binary tree
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     * Prints rightChild - leftChild - root
     *
     * @param localRoot The local root of the binary tree
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

    /**
     * Prints the tree in a breadth first search order This is similar to
     * pre-order traversal, but instead of being implemented with a stack (or
     * recursion), it is implemented with a queue
     *
     * @param localRoot The local root of the binary tree
     */
    public void bfs(Node localRoot) {
        // Create a queue for the order of the nodes
        Queue<Node> queue = new LinkedList<Node>();

        // If the give root is null, then we don't add to the queue
        // and won't do anything
        if (localRoot != null) {
            queue.add(localRoot);
        }

        // Continue until the queue is empty
        while (!queue.isEmpty()) {
            // Get the next node on the queue to visit
            localRoot = queue.remove();

            // Print the data from the node we are visiting
            System.out.print(localRoot.data + " ");

            // Add the children to the queue if not null
            if (localRoot.right != null) {
                queue.add(localRoot.right);
            }
            if (localRoot.left != null) {
                queue.add(localRoot.left);
            }
        }
    }
}
