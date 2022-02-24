package com.thealgorithms.datastructures.stacks;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The function MaximumMinimumWindow::calculateMaxOfMin did not have any test suite and the
 * branch coverage was 0%.
 *
 * Notice that the function only takes array of positive integers. The only requirement that
 * needs to be tested is that the input array consists of positive integers. This will give a
 * branch coverage of 100%.
 */
public class MaximumMinimumWindowTest {
    /**
     * Test the requirement to input an array of positive integers
     */
    @Test
    void successTest1(){
        int[] arr = new int[]{10, 20, 30, 10};
        int[] target = new int[]{30, 20, 10, 10};
        int[] res = MaximumMinimumWindow.calculateMaxOfMin(arr, arr.length);
        assertArrayEquals(target, res);
    }

    /**
     * Test the requirement to input an array of positive integers of length 1
     */
    @Test
    void successTest2(){
        int[] arr = new int[]{0};
        int[] target = new int[]{0};
        int[] res = MaximumMinimumWindow.calculateMaxOfMin(arr, arr.length);
        assertArrayEquals(target, res);
    }

    /**
     * Test the requirement to input an array of positive integers
     */
    @Test
    void successTest3(){
        int[] arr = new int[]{10, 10, 10};
        int[] target = new int[]{10, 10, 10};
        int[] res = MaximumMinimumWindow.calculateMaxOfMin(arr, arr.length);
        assertArrayEquals(target, res);
    }

    /**
     * Test if an exception is thrown when the input array contains negative integer
     */
    @Test
    void exceptionThrownTest(){
        int[] arr = new int[]{1, -10};
        assertThrows(IllegalArgumentException.class, () -> MaximumMinimumWindow.calculateMaxOfMin(arr, arr.length));
    }
}
