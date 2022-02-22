package com.thealgorithms.datastructures;

import com.thealgorithms.datastructures.trees.BinaryTree;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {
    @AfterAll
    static void tearDown() {
        for (int i = 0; i < BinaryTree.numBranchesInRemove; i++) {
            if (!BinaryTree.coveredBranches.contains(i)) {
                System.out.println("Branch " + i + " not covered in BinaryTree::remove");
            }
        }
        double coverage = BinaryTree.coveredBranches.size() / (double) BinaryTree.numBranchesInRemove;
        System.out.printf("Total branch coverage of BinaryTree::remove: %.2f%%\n", coverage*100);
    }
}
