package com.thealgorithms.dynamicprogramming;

/**
 * Given a text and wildcard pattern implement a wildcard pattern matching
 * algorithm that finds if wildcard is matched with text. The matching should
 * cover the entire text ?-> matches single characters *-> match the sequence of
 * characters
 *
 */
/**
 * For calculation of Time and Space Complexity. Let N be length of src and M be
 * length of pat
 *
 */
public class RegexMatching {

    // Method 1: Using Recursion
    // Time Complexity=0(2^(N+M)) Space Complexity=Recursion Extra Space

    /**
     * This algorithm tries to match a String against a given Wildcard expansion.
     * If the pattern contains no wildcard, the strings will need to be identical to match.
     *
     * @param src non-null String which is matched to our wildcard expansion
     * @param pat non-null String which contains the wildcard to expand
     * @return true if the wildcard pattern matches the src string
     */
    static boolean regexRecursion(String src, String pat) {
        if (src.length() == 0 && pat.length() == 0) {
            // An empty string and empty pattern brings us here
            return true;
        }
        if (src.length() != 0 && pat.length() == 0) {
            // An empty pattern, but still more in our string, will bring us here
            return false;
        }
        if (src.length() == 0 && pat.length() != 0) {
            // If we've reached the end of the src string, but there's still more in the pattern
            for (int i = 0; i < pat.length(); i++) {
                if (pat.charAt(i) != '*') {
                    // If every remaining character in the pattern isn't a * wildcard
                    return false;
                }
            }
            // We've reached the end of src, and there's only wildcards left in pattern
            return true;
        }
        char chs = src.charAt(0);
        char chp = pat.charAt(0);

        String ros = src.substring(1);
        String rop = pat.substring(1);

        boolean ans;
        if (chs == chp || chp == '?') {
            // The same character is in both src and pat HEAD, or pat starts on a single char wildcard
            ans = regexRecursion(ros, rop);
        } else if (chp == '*') {
            // If chs and chp aren't the same, and the head of the pattern starts with a * wildcard
            boolean blank = regexRecursion(src, rop);
            boolean multiple = regexRecursion(ros, pat);
            // This here will split into multiple branches depending on the returned values:
            // blank will continue on with testing with the rest of the pattern on the string, seeing if the wildcard
            // has reached its end.
            // multiple will assume that the current character in the string should be expanded by the wildcard
            ans = blank || multiple;
        } else {
            // Otherwise there's no match, and we'll return back a false on this matching.
            ans = false;
        }
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
