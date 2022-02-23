package com.thealgorithms.datastructures.trees;

import com.thealgorithms.datastructures.trees.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * To ensure that the remove function has been properly implemented we have
 * to test at least the following five cases:
 * 1) It is possible to remove the root node.
 * 2) It is possible to remove a node that does not have children.
 * 3) It is possible to remove a node with one child. The child node should then replace the removed node.
 * 4) It is possible to remove a node with two children. This is the most difficult case to implement.
 *    We have two different allowed outcomes which depend on the implementation,
 *    either the min node in the right subtree should replace the removed node,
 *    or the max node in the left subtree should replace the removed node (both options work).
 * 5) If the remove function is called with a key that does not exist in the tree, then we should not remove any node in the tree.
 */
public class BinaryTreeTest {

    /**
     * Test requirement 1) It is possible to remove the root node.
     */
    @Test
    public void removeRootNodeTest() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);

        // Ensure that the node exists.
        assertTrue(tree.contains(1));

        // Remove the node.
        assertTrue(tree.remove(1));

        // Ensure that the node is removed.
        assertFalse(tree.contains(1));
    }

    /**
     * Test requirement 2) It is possible to remove a node that does not have children.
     */
    @Test
    public void removeNodeWithoutChildrenTest() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        tree.put(2);

        // Ensure that the nodes exist.
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));

        // Remove the node with key 2.
        assertTrue(tree.remove(2));

        // Ensure that the node with key 1 is still in the tree.
        assertTrue(tree.contains(1));

        // Ensure that the node with key 2 is removed.
        assertFalse(tree.contains(2));
    }

    /**
     * Test requirement 3) It is possible to remove a node with one child.
     */
    @Test
    public void removeNodeWithOneChildTest() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);

        // Ensure that the nodes exist.
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));

        // Remove the node with key 2.
        assertTrue(tree.remove(2));

        // Ensure that the node with key 1 is still in the tree.
        assertTrue(tree.contains(1));

        // Ensure that the node with key 2 is removed.
        assertFalse(tree.contains(2));

        // Ensure that the node with key 3 is still in the tree.
        assertTrue(tree.contains(3));
    }

    /**
     * Test requirement 4) It is possible to remove a node with two children.
     */
    @Test
    public void removeNodWithTwoChildrenTest() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        tree.put(3);    // Node with key 3 will have two children.
        tree.put(2);
        tree.put(4);

        // Ensure that the nodes exist.
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));

        // Remove the node with key 3.
        assertTrue(tree.remove(3));

        // Ensure that the node with key 1 is still in the tree.
        assertTrue(tree.contains(1));

        // Ensure that the node with key 2 is still in the tree.
        assertTrue(tree.contains(2));

        // Ensure that the node with key 3 is removed.
        assertFalse(tree.contains(3));

        // Ensure that the node with key 4 is still in the tree.
        assertTrue(tree.contains(4));
    }

    /**
     * Test requirement 5) If the remove function is called with a key that does not exist in the tree,
     * then we should not remove any node in the tree.
     */
    @Test
    public void removeNonExistingNodeTest() {
        BinaryTree tree = new BinaryTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);

        // Ensure that the nodes exist.
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));

        // Try to remove a node that does not exist.
        assertFalse(tree.remove(4));

        // Ensure that nothing has changed.
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
    }
}