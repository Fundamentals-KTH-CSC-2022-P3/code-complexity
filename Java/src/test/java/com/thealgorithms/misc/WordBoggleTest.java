package com.thealgorithms.misc;

import org.junit.jupiter.api.AfterAll;

public class WordBoggleTest {
    @AfterAll
    static void tearDown() {
        for (int i = 0; i < WordBoggle.numBranchesInGetNeighbors; i++) {
            if (!WordBoggle.coveredBranches.contains(i)) {
                System.out.println("Branch " + i + " not covered in WordBoggle::getNeighbors");
            }
        }
        double coverage = WordBoggle.coveredBranches.size() / (double) WordBoggle.numBranchesInGetNeighbors;
        System.out.printf("Total branch coverage of WordBoggle::getNeighbors: %.2f%%", coverage*100);
    }
}
