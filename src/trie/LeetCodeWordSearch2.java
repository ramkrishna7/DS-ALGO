import java.util.ArrayList;
import java.util.List;

public class LeetCodeWordSearch2 {
    private static int[] x = {0, 0, 1, -1};
    private static int[] y = {1, -1, 0, 0};
    private static List<String> answer;

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        answer = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Character first = board[i][j];
                if (trie.getRoot().getChildren().get(first) != null) {
                    wordSearch(i, j, board, trie.getRoot());
                }
            }
        }
        return answer;
    }

    private void wordSearch(int row, int column, char[][] board, TrieNode trieNode) {
        char originalChar = board[row][column];
        TrieNode current = trieNode.getChildren().get(board[row][column]);

        if (board[row][column] == '$' || current == null) {
            return;
        }
        if (current.isEndOfWord()) {
            answer.add(current.getContent());
            current.setEndOfWord(false);
        }
        board[row][column] = '$';
        for (int k = 0; k < x.length; k++) {
            int r = row + x[k];
            int c = column + y[k];
            if (isSafe(r, c, board)) {
                wordSearch(r, c, board, current);
            }
        }
        board[row][column] = originalChar; //backtracking
    }

    private Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        return trie;
    }

    private boolean isSafe(int i, int j, char[][] board) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            return true;
        }
        return false;
    }
}
