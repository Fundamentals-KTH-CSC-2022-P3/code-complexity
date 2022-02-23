package com.thealgorithms.trees;

import com.thealgorithms.datastructures.trees.RedBlackBST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedBlackBSTTest {
    @Test
    void testTreeCanDeleteNode() {
        RedBlackBST tree = new RedBlackBST();

        tree.insert(tree.createNewNode(1));
        tree.insert(tree.createNewNode(2));
        tree.insert(tree.createNewNode(3));
        tree.insert(tree.createNewNode(4));
        tree.insert(tree.createNewNode(5));

        assertNotNull(tree.findNode(tree.createNewNode(1), tree.root));
        tree.delete(tree.createNewNode(1));
        assertNull(tree.findNode(tree.createNewNode(1), tree.root));
    }
}
