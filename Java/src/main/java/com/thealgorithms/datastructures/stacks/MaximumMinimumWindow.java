package com.thealgorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an positive integer array. The task is to find the maximum of the minimum of
 * every window size in the array. Note: Window size varies from 1 to the size
 * of the Array.
 * <p>
 * For example,
 * <p>
 * N = 7
 * arr[] = {10,20,30,50,10,70,30}
 * <p>
 * So the answer for the above would be : 70 30 20 10 10 10 10
 * <p>
 * We need to consider window sizes from 1 to length of array in each iteration.
 * So in the iteration 1 the windows would be [10], [20], [30], [50], [10],
 * [70], [30]. Now we need to check the minimum value in each window. Since the
 * window size is 1 here the minimum element would be the number itself. Now the
 * maximum out of these is the result in iteration 1. In the second iteration we
 * need to consider window size 2, so there would be [10,20], [20,30], [30,50],
 * [50,10], [10,70], [70,30]. Now the minimum of each window size would be
 * [10,20,30,10,10] and the maximum out of these is 30. Similarly we solve for
 * other window sizes.
 *
 */
public class MaximumMinimumWindow {

    private static int[] smallerOnLeft(int[] arr){
        // find indexes of the first smaller elements on the left side of each element
        int n = arr.length;
        int[] left = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (!s.empty()) {
                left[i] = s.peek();
            } else {
                left[i] = -1;
            }

            s.push(i);
        }
        return left;
    }

    private static int[] smallerOnRight(int[] arr){
        // find indexes of the first smaller elements on the right side of each element
        int n = arr.length;
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n-1; i > -1; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (!s.empty()) {
                right[i] = s.peek();
            } else {
                right[i] = n;
            }

            s.push(i);
        }
        return right;
    }

    /**
     * This function contains the logic of finding maximum of minimum for every
     * window size (from 1 to n), by comparing minimums of all
     * lengths computed using left[] and right[]
     *
     * @param arr Array of positive integers.
     * @return result array
     */
    public static int[] calculateMaxOfMin(int[] arr) {
        int[] left = smallerOnLeft(arr);
        int[] right = smallerOnRight(arr);
        int n = arr.length;

        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        // Print the result
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
        // remove the first element (an unwanted 0) in ans
        ans = Arrays.copyOfRange(ans, 1, ans.length);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 50, 10, 70, 30};
        int[] target = new int[]{70, 30, 20, 10, 10, 10, 10};
        int[] res = calculateMaxOfMin(arr);
        assert Arrays.equals(target, res);
    }

}
