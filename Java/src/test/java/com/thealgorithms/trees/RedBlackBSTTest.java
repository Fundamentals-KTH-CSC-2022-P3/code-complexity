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
