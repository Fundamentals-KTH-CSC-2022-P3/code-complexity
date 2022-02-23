package com.thealgorithms.misc;

import java.util.*;

public class WordBoggle {

    /**
     * O(nm * 8^s + ws) time where n = width of boggle board, m = height of
     * boggle board, s = length of longest word in string array, w = length of
     * string array, 8 is due to 8 explorable neighbours O(nm + ws) space.
     */
    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                explore(i, j, board, trie.root, visited, finalWords);
            }
        }
        return new ArrayList<>(finalWords);
    }

    public static void main(String[] args) {
        // Testcase
        List<String> ans
                = new ArrayList<>(
                        Arrays.asList("a", "boggle", "this", "NOTRE_PEATED", "is", "simple", "board"));
        assert (boggleBoard(
                new char[][]{
                    {'t', 'h', 'i', 's', 'i', 's', 'a'},
                    {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                    {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                    {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                    {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                    {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                    {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                    {'N', 'O', 'T', 'R', 'E', '_', 'P'},
                    {'x', 'x', 'D', 'E', 'T', 'A', 'E'},},
                new String[]{
                    "this",
                    "is",
                    "not",
                    "a",
                    "simple",
                    "test",
                    "boggle",
                    "board",
                    "REPEATED",
                    "NOTRE_PEATED",})
                .equals(ans));
    }

    public static void explore(
            int i,
            int j,
            char[][] board,
            TrieNode trieNode,
            boolean[][] visited,
            Set<String> finalWords) {
        if (visited[i][j]) {
            return;
        }

        char letter = board[i][j];
        if (!trieNode.children.containsKey(letter)) {
            return;
        }
        visited[i][j] = true;
        trieNode = trieNode.children.get(letter);
        if (trieNode.children.containsKey('*')) {
            finalWords.add(trieNode.word);
        }

        List<Integer[]> neighbors = getNeighbors(i, j, board);
        for (Integer[] neighbor : neighbors) {
            explore(neighbor[0], neighbor[1], board, trieNode, visited, finalWords);
        }

        visited[i][j] = false;
    }

    /**
     * Total number of branches in getNeighbors
     */
    public static final int numBranchesInGetNeighbors = 25;

    /**
     * Data structure for holding coverage information of getNeighbors
     */
    public static Set<Integer> coveredBranches = new HashSet<>();

    /**
     * Method for returning all valid neighbor coordinates in a 2d array. Invalid coordinates are exactly the same as
     * out of bounds coordinates. Neighbors are coordinates on the form (i ± 1, j ± 1).
     *
     * N.B. I *think* that you are only ever meant to call this method with 0 ≤ i < board.length and 0 ≤ j < board[0].length
     * and board[n].length = board[m].length for all n, m. However, no bounds checking is done in the original
     * implementation, and no documentation was written, so this is guesswork from me. //Arvid
     * @param i The first coordinate of the point to check for neighbors
     * @param j The second coordinate of the point to check for neighbors
     * @param board The 2d array where the points are positioned
     * @return A list of Integer[2]:s, each representing the coordinates of a neighbor
     */
    public static List<Integer[]> getNeighbors(int i, int j, char[][] board) {
        List<Integer[]> neighbors = new ArrayList<>();
        // This is not technically a branch, but it is an edge in the CFG, so I felt like including it. //Arvid
        coveredBranches.add(0);
        if (i > 0) {
            coveredBranches.add(1);
            if (j > 0) {
                coveredBranches.add(2);
                neighbors.add(new Integer[]{i - 1, j - 1});
            } else {
                coveredBranches.add(3);
            }
        } else {
            coveredBranches.add(4);
        }

        if (i > 0) {
            coveredBranches.add(5);
            if (j < board[0].length - 1) {
                coveredBranches.add(6);
                neighbors.add(new Integer[]{i - 1, j + 1});
            } else {
                coveredBranches.add(7);
            }
        } else {
            coveredBranches.add(8);
        }

        if (i < board.length - 1) {
            coveredBranches.add(9);
            if (j < board[0].length - 1) {
                coveredBranches.add(10);
                neighbors.add(new Integer[]{i + 1, j + 1});
            } else {
                coveredBranches.add(11);
            }
        } else {
            coveredBranches.add(12);
        }

        if (i < board.length - 1) {
            coveredBranches.add(13);
            if (j > 0) {
                coveredBranches.add(14);
                neighbors.add(new Integer[]{i + 1, j - 1});
            } else {
                coveredBranches.add(15);
            }
        } else {
            coveredBranches.add(16);
        }

        if (i > 0) {
            coveredBranches.add(17);
            neighbors.add(new Integer[]{i - 1, j});
        } else {
            coveredBranches.add(18);
        }

        if (i < board.length - 1) {
            coveredBranches.add(19);
            neighbors.add(new Integer[]{i + 1, j});
        } else {
            coveredBranches.add(20);
        }

        if (j > 0) {
            coveredBranches.add(21);
            neighbors.add(new Integer[]{i, j - 1});
        } else {
            coveredBranches.add(22);
        }

        if (j < board[0].length - 1) {
            coveredBranches.add(23);
            neighbors.add(new Integer[]{i, j + 1});
        } else {
            coveredBranches.add(24);
        }

        return neighbors;
    }
}

// Trie used to optimize string search
class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    String word = "";
}

class Trie {

    TrieNode root;
    char endSymbol;

    public Trie() {
        this.root = new TrieNode();
        this.endSymbol = '*';
    }

    public void add(String str) {
        TrieNode node = this.root;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!node.children.containsKey(letter)) {
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
            }
            node = node.children.get(letter);
        }
        node.children.put(this.endSymbol, null);
        node.word = str;
    }
}
