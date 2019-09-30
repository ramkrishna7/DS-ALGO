public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), node -> new TrieNode());
        }
        current.setEndOfWord(true);
        current.setContent(word);
    }

    public boolean isWordPresent(String word) {
        TrieNode current = root;

        for (Character ch : word.toCharArray()) {
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean isEmpty() {
        return root == null || root.getChildren().size() == 0;
    }

}
