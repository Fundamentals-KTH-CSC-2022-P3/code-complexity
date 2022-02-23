package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.AfterAll;

public class MaximumMinimumWindowTest {
    @AfterAll
    static void tearDown() {
        for (int i = 0; i < MaximumMinimumWindow.numBranchesInMaxofMin; i++) {
            if (!MaximumMinimumWindow.coveredBranches.contains(i)) {
                System.out.println("Branch " + i + " not covered in MaximumMinimumWindow::calculateMaxOfMin");
            }
        }
        double coverage = MaximumMinimumWindow.coveredBranches.size() / (double) MaximumMinimumWindow.numBranchesInMaxofMin;
        System.out.printf("Total branch coverage of MaximumMinimumWindow::calculateMaxOfMin: %.2f%%\n", coverage * 100);
    }
}

