package com.thealgorithms.datastructures.stacks;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

/**
 * Given an integer array. The task is to find the maximum of the minimum of
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
 * @author sahil
 */
public class MaximumMinimumWindow {

    /**
     * This function contains the logic of finding maximum of minimum for every
     * window size using Stack Data Structure.
     *
     * @param arr Array containing the numbers
     * @param n Length of the array
     * @return result array
     */

    /**
     * Total number of branches in the calculateMaxOfMin function
     */
    public static final int numBranchesInMaxofMin = 29;

    /**
     * Data structure for holding coverage information of the calculateMaxOfMin function
     */
    public static Set<Integer> coveredBranches = new HashSet<>();

    public static int[] calculateMaxOfMin(int[] arr, int n) {
        // This is not technically a branch, but it is an edge in the CFG.
        coveredBranches.add(0);

        Stack<Integer> s = new Stack<>();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        for (int i = 0; i < n; i++) {
            coveredBranches.add(1);
            left[i] = -1;
            right[i] = n;
        }
        coveredBranches.add(2);

        for (int i = 0; i < n; i++) {
            coveredBranches.add(3);
            while (!s.empty()) {
                coveredBranches.add(4);
                if (!(arr[s.peek()] >= arr[i])) {
                    coveredBranches.add(5);
                    break;
                } else {
                    coveredBranches.add(6);
                    s.pop();
                }
            }
            coveredBranches.add(7);

            if (!s.empty()) {
                coveredBranches.add(8);
                left[i] = s.peek();
            } else{
                coveredBranches.add(9);
            }

            s.push(i);
        }
        coveredBranches.add(10);

        while (!s.empty()) {
            coveredBranches.add(11);
            s.pop();
        }
        coveredBranches.add(12);

        for (int i = n - 1; i >= 0; i--) {
            coveredBranches.add(13);
            while (!s.empty()) {
                coveredBranches.add(14);
                if (!(arr[s.peek()] >= arr[i])) {
                    coveredBranches.add(15);
                    break;
                } else {
                    coveredBranches.add(16);
                    s.pop();
                }
            }
            coveredBranches.add(17);

            if (!s.empty()) {
                coveredBranches.add(18);
                right[i] = s.peek();
            } else{
                coveredBranches.add(19);
            }

            s.push(i);
        }
        coveredBranches.add(20);

        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            coveredBranches.add(21);
            ans[i] = 0;
        }
        coveredBranches.add(22);

        for (int i = 0; i < n; i++) {
            coveredBranches.add(23);
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        coveredBranches.add(24);

        for (int i = n - 1; i >= 1; i--) {
            coveredBranches.add(25);
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        coveredBranches.add(26);

        // Print the result
        for (int i = 1; i <= n; i++) {
            coveredBranches.add(27);
            System.out.print(ans[i] + " ");
        }
        coveredBranches.add(28);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 50, 10, 70, 30};
        int[] target = new int[]{70, 30, 20, 10, 10, 10, 10};
        int[] res = calculateMaxOfMin(arr, arr.length);
        assert Arrays.equals(target, res);
    }

}
