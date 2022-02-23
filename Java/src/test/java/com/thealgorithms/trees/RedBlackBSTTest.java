package com.thealgorithms.trees;

import com.thealgorithms.datastructures.trees.RedBlackBST;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedBlackBSTTest {
    @AfterAll
    static void tearDown() {
        for (int i = 0; i < RedBlackBST.numBranchesInDeleteFixup; i++) {
            if (!RedBlackBST.coveredBranches.contains(i)) {
                System.out.println("Branch " + i + " not covered in RedBlackBST::deleteFixup");
            }
        }
        double coverage = RedBlackBST.coveredBranches.size() / (double) RedBlackBST.numBranchesInDeleteFixup;
        System.out.printf("Total branch coverage of RedBlackBST::deleteFixup: %.2f%%\n", coverage*100);
    }

    @Test
    void testTreeCanDeleteBlackNode() {
        RedBlackBST tree = new RedBlackBST();

        tree.insert(tree.createNewNode(1));
        tree.insert(tree.createNewNode(2));
        tree.insert(tree.createNewNode(3));
        tree.insert(tree.createNewNode(4));
        tree.insert(tree.createNewNode(5));

        // the node "1" here, would be black
        assertNotNull(tree.findNode(tree.createNewNode(1), tree.root));
        tree.delete(tree.createNewNode(1));
        assertNull(tree.findNode(tree.createNewNode(1), tree.root));
    }

    @Test
    void testTreeCanDeleteRedNode() {
        RedBlackBST tree = new RedBlackBST();

        tree.insert(tree.createNewNode(1));
        tree.insert(tree.createNewNode(2));
        tree.insert(tree.createNewNode(3));
        tree.insert(tree.createNewNode(4));
        tree.insert(tree.createNewNode(5));

        // the node "5" here, would be red
        assertNotNull(tree.findNode(tree.createNewNode(5), tree.root));
        tree.delete(tree.createNewNode(5));
        assertNull(tree.findNode(tree.createNewNode(5), tree.root));
    }

    @Test
    void testTreeCanDeleteAllNodesInATree() {
        RedBlackBST tree = new RedBlackBST();

        tree.insert(tree.createNewNode(1));
        tree.insert(tree.createNewNode(2));
        tree.insert(tree.createNewNode(3));
        tree.insert(tree.createNewNode(4));
        tree.insert(tree.createNewNode(5));

        tree.delete(tree.createNewNode(1));
        tree.delete(tree.createNewNode(2));
        tree.delete(tree.createNewNode(3));
        tree.delete(tree.createNewNode(4));
        tree.delete(tree.createNewNode(5));
        assertNull(tree.findNode(tree.createNewNode(1), tree.root));
        assertNull(tree.findNode(tree.createNewNode(2), tree.root));
        assertNull(tree.findNode(tree.createNewNode(3), tree.root));
        assertNull(tree.findNode(tree.createNewNode(4), tree.root));
        assertNull(tree.findNode(tree.createNewNode(5), tree.root));
    }

    @Test
    void testTreeCanDeleteTheRootNode() {
        RedBlackBST tree = new RedBlackBST();

        tree.insert(tree.createNewNode(1));
        tree.insert(tree.createNewNode(2));
        tree.insert(tree.createNewNode(3));
        tree.insert(tree.createNewNode(4));
        tree.insert(tree.createNewNode(5));

        assertEquals(2, tree.root.key);
        tree.delete(tree.createNewNode(2));

        assertNotEquals(2, tree.root.key);
        assertNull(tree.findNode(tree.createNewNode(2), tree.root));

        // All other nodes should be there
        assertNotNull(tree.findNode(tree.createNewNode(1), tree.root));
        assertNotNull(tree.findNode(tree.createNewNode(3), tree.root));
        assertNotNull(tree.findNode(tree.createNewNode(4), tree.root));
        assertNotNull(tree.findNode(tree.createNewNode(5), tree.root));
    }
}
