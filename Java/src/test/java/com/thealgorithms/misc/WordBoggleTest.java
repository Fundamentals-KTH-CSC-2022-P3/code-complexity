package com.thealgorithms.misc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBoggleTest {
    private final char[][] testBoard = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
    };

    @AfterAll
    static void tearDown() {
        for (int i = 0; i < WordBoggle.numBranchesInGetNeighbors; i++) {
            if (WordBoggle.coveredBranches.contains(i)) {
                System.out.println("Branch " + i + " covered in WordBoggle::getNeighbors");
            } else {
                System.out.println("Branch " + i + " not covered in WordBoggle::getNeighbors");
            }
        }
        double coverage = WordBoggle.coveredBranches.size() / (double) WordBoggle.numBranchesInGetNeighbors;
        System.out.printf("Total branch coverage of WordBoggle::getNeighbors: %.2f%%", coverage*100);
    }

    private static boolean hasSameCoordinatePairs(List<Integer[]> l1, List<Integer[]> l2) {
        if (l1 == null) {
            return l2 == null;
        }

        if (l1.size() != l2.size()) {
            return false;
        }

        /*
         * We do this slightly awkward and quadratic check as to not get false positives for cases such as
         * [[0,0], [0,1]] and [[0,0], [0,0]]. We could also sort both lists, probably.
         */
        for (int i = 0; i < l1.size(); i++) {
            boolean hasSame = false;
            for (int j = 0; j < l2.size(); j++) {
                if (Arrays.equals(l2.get(j), l1.get(i))) {
                    hasSame = true;
                    l2.remove(j);
                    break;
                }
            }
            if (!hasSame) {
                return false;
            }
        }
        return l2.isEmpty();
    }

    @Test
    void getNeighborsGivesAllNeighborsForCenter() {
        var expected = Arrays.asList(new Integer[][]{
                {0,0}, {0,1}, {0,2},
                {1,0},        {1,2},
                {2,0}, {2,1}, {2,2},
        });
        var neighbors = WordBoggle.getNeighbors(1, 1, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    @Test
    void getNeighborsGivesThreeNeighborsForTopLeft() {
        var expected = Arrays.asList(new Integer[][]{
                {1,0}, {0,1}, {1,1}
        });
        var neighbors = WordBoggle.getNeighbors(0, 0, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    @Test
    void getNeighborsGivesThreeNeighborsForBottomRight() {
        var expected = Arrays.asList(new Integer[][]{
                {1,2}, {2,1}, {1,1}
        });
        var neighbors = WordBoggle.getNeighbors(2, 2, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    @Test
    void getNeighborsGivesFiveNeighborsForTopCenter() {
        var expected = Arrays.asList(new Integer[][]{
                {0,0},        {2,0},
                {0,1}, {1,1}, {2,1}
        });
        var neighbors = WordBoggle.getNeighbors(1, 0, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    @Test
    void getNeighborsGivesFiveNeighborsForBottomRight() {
        var expected = Arrays.asList(new Integer[][]{
                {0,1}, {1,1}, {2,1},
                {0,2},        {2,2}
        });
        var neighbors = WordBoggle.getNeighbors(1, 2, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }
}
