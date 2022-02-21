package com.thealgorithms.misc;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBoggleTest {

    // The board that we check for neighbors in when testing getNeighbors.
    private final char[][] testBoard = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
    };

    /**
     * Test that an inner coordinate gives the correct eight neighbors
     */
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

    /**
     * Test that the top left corner gives the correct three neighbors
     */
    @Test
    void getNeighborsGivesThreeNeighborsForTopLeft() {
        var expected = Arrays.asList(new Integer[][]{
                {1,0}, {0,1}, {1,1}
        });
        var neighbors = WordBoggle.getNeighbors(0, 0, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    /**
     * Test that the bottom right corner gives the correct three neighbors
     */
    @Test
    void getNeighborsGivesThreeNeighborsForBottomRight() {
        var expected = Arrays.asList(new Integer[][]{
                {1,2}, {2,1}, {1,1}
        });
        var neighbors = WordBoggle.getNeighbors(2, 2, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    /**
     * Test that the top edge gives the correct five neighbors
     */
    @Test
    void getNeighborsGivesFiveNeighborsForTopCenter() {
        var expected = Arrays.asList(new Integer[][]{
                {0,0},        {2,0},
                {0,1}, {1,1}, {2,1}
        });
        var neighbors = WordBoggle.getNeighbors(1, 0, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    /**
     * Test that the bottom edge gives the correct five neighbors
     */
    @Test
    void getNeighborsGivesFiveNeighborsForBottom() {
        var expected = Arrays.asList(new Integer[][]{
                {0,1}, {1,1}, {2,1},
                {0,2},        {2,2}
        });
        var neighbors = WordBoggle.getNeighbors(1, 2, testBoard);
        assertTrue(hasSameCoordinatePairs(expected, neighbors));
    }

    /**
     * Helper method for checking that two lists contains the same coordinates
     * @param l1 A list of coordinates
     * @param l2 A list of coordinates. Must implement remove()
     * @return true if l1 and l2 contained exactly the same coordinates
     */
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
}
