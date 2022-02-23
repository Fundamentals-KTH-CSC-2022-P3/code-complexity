package com.thealgorithms.dynamicprogramming;

/**
 * Given a text and wildcard pattern implement a wildcard pattern matching
 * algorithm that finds if wildcard is matched with text. The matching should
 * cover the entire text ?-> matches single characters *-> match the sequence of
 * characters
 *
 */

import java.util.HashSet;

/**
 * For calculation of Time and Space Complexity. Let N be length of src and M be
 * length of pat
 *
 */
public class RegexMatching {

    static final HashSet<Integer> passedBranches = new HashSet<>();
    static final int numberOfBranches = 14;

    // Method 1: Using Recursion
    // Time Complexity=0(2^(N+M)) Space Complexity=Recursion Extra Space
    static boolean regexRecursion(String src, String pat) {
        if (pat.length() == 0) {
            // Branch 1
            passedBranches.add(1);
            if (src.length() == 0) {
                // Branch 2: Leaf 1
                passedBranches.add(2);
                return true;
            }
            // Branch 3: Leaf 2
            passedBranches.add(3);
            return false;
        } else if (src.length() == 0) {
            for (int i = 0; i < pat.length(); i++) {
                // Branch 4
                passedBranches.add(4);
                if (pat.charAt(i) != '*') {
                    // Branch 5: Leaf 3
                    passedBranches.add(5);
                    return false;
                }
            }
            // Branch 6: Leaf 4
            passedBranches.add(6);
            return true;
        }
        char chs = src.charAt(0);
        char chp = pat.charAt(0);

        String ros = src.substring(1);
        String rop = pat.substring(1);

        boolean ans;
        if (chs == chp || chp == '?') {
            // Branch 7
            passedBranches.add(7);
            var retval = regexRecursion(ros, rop);
            if (retval) {
                // Branch 8
                passedBranches.add(8);
                ans = true;
            } else {
                // Branch 9
                passedBranches.add(9);
                ans = false;
            }
        } else if (chp == '*') {
            // Branch 10
            passedBranches.add(10);
            boolean blank = regexRecursion(src, rop);
            boolean multiple = regexRecursion(ros, pat);
            // Assignment of variable branching into 3
            if (blank) {
                // Branch 11
                passedBranches.add(11);
                ans = true;
            } else if (multiple) {
                // Branch 12
                passedBranches.add(12);
                ans = true;
            } else {
                // Branch 13
                passedBranches.add(13);
                ans = false;
            }

        } else {
            // Branch 14
            passedBranches.add(14);
            ans = false;
        }
        // Leaf 5
        return ans;
    }

    // Method 2: Using Recursion and breaking string using virtual index
    // Time Complexity=0(2^(N+M)) Space Complexity=Recursion Extra Space
    static boolean regexRecursion(String src, String pat, int svidx, int pvidx) {
        if (src.length() == svidx && pat.length() == pvidx) {
            return true;
        }
        if (src.length() != svidx && pat.length() == pvidx) {
            return false;
        }
        if (src.length() == svidx && pat.length() != pvidx) {
            for (int i = pvidx; i < pat.length(); i++) {
                if (pat.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        char chs = src.charAt(svidx);
        char chp = pat.charAt(pvidx);

        boolean ans;
        if (chs == chp || chp == '?') {
            ans = regexRecursion(src, pat, svidx + 1, pvidx + 1);
        } else if (chp == '*') {
            boolean blank = regexRecursion(src, pat, svidx, pvidx + 1);
            boolean multiple = regexRecursion(src, pat, svidx + 1, pvidx);
            ans = blank || multiple;
        } else {
            ans = false;
        }
        return ans;
    }

    // Method 3: Top-Down DP(Memoization)
    // Time Complexity=0(N*M) Space Complexity=0(N*M)+Recursion Extra Space
    static boolean regexRecursion(String src, String pat, int svidx, int pvidx, int[][] strg) {
        if (src.length() == svidx && pat.length() == pvidx) {
            return true;
        }
        if (src.length() != svidx && pat.length() == pvidx) {
            return false;
        }
        if (src.length() == svidx && pat.length() != pvidx) {
            for (int i = pvidx; i < pat.length(); i++) {
                if (pat.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (strg[svidx][pvidx] != 0) {
            return strg[svidx][pvidx] == 1 ? false : true;
        }
        char chs = src.charAt(svidx);
        char chp = pat.charAt(pvidx);

        boolean ans;
        if (chs == chp || chp == '?') {
            ans = regexRecursion(src, pat, svidx + 1, pvidx + 1, strg);
        } else if (chp == '*') {
            boolean blank = regexRecursion(src, pat, svidx, pvidx + 1, strg);
            boolean multiple = regexRecursion(src, pat, svidx + 1, pvidx, strg);
            ans = blank || multiple;
        } else {
            ans = false;
        }
        strg[svidx][pvidx] = ans == false ? 1 : 2;
        return ans;
    }

    // Method 4: Bottom-Up DP(Tabulation)
    // Time Complexity=0(N*M) Space Complexity=0(N*M)
    static boolean regexBU(String src, String pat) {

        boolean strg[][] = new boolean[src.length() + 1][pat.length() + 1];
        strg[src.length()][pat.length()] = true;
        for (int row = src.length(); row >= 0; row--) {
            for (int col = pat.length() - 1; col >= 0; col--) {
                if (row == src.length()) {
                    if (pat.charAt(col) == '*') {
                        strg[row][col] = strg[row][col + 1];
                    } else {
                        strg[row][col] = false;
                    }
                } else {
                    char chs = src.charAt(row);
                    char chp = pat.charAt(col);

                    boolean ans;
                    if (chs == chp || chp == '?') {
                        ans = strg[row + 1][col + 1];
                    } else if (chp == '*') {
                        boolean blank = strg[row][col + 1];
                        boolean multiple = strg[row + 1][col];
                        ans = blank || multiple;
                    } else {
                        ans = false;
                    }
                    strg[row][col] = ans;
                }
            }
        }
        return strg[0][0];
    }

    public static void main(String[] args) {

        String src = "aa";
        String pat = "*";
        System.out.println("Method 1: " + regexRecursion(src, pat));
        System.out.println("Method 2: " + regexRecursion(src, pat, 0, 0));
        System.out.println("Method 3: " + regexRecursion(src, pat, 0, 0, new int[src.length()][pat.length()]));
        System.out.println("Method 4: " + regexBU(src, pat));

    }

}
// Memoization vs Tabulation : https://www.geeksforgeeks.org/tabulation-vs-memoization/
// Question Link : https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1
