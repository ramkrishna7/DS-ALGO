import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AutoComplete {
    private Trie dictionary;

    public AutoComplete() {
        dictionary = new Trie();
    }

    public static void main(String[] args) {
        String[] tutorials = {
                "ActionScript", "Angular",
                "Bootstrap",
                "C", "C++",
                "Groovy", "Guava",
                "Jquery", "Java", "JavaScript", "Junit", "Jasmine",
                "Ruby", "React", "REST",
                "Scala", "Swing", "SOAP",
                "XHTML", "Xunit"
        };

        AutoComplete autoComplete = new AutoComplete();
        autoComplete.buildTrie(tutorials);
        String input = "Ja";
        Set<String> completeWords = autoComplete.autoCompleteWord(input);
        for (String word: completeWords) {
            System.out.println(word);
        }
    }

    private void buildTrie(String[] words) {
        for (String word:words) {
            dictionary.addWord(word);
        }
    }

    public Set<String> autoCompleteWord(String input) {
        TrieNode current = dictionary.getRoot();
        for (Character ch : input.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null) {
                break;
            }
        }
        Set<String> completeWords = new HashSet<>();
        getCompleteWords(current, completeWords);
        return completeWords;
    }

    private void getCompleteWords(TrieNode node, Set<String> completeWords) {
        if (node == null) {
            return;
        }
        if (node != null && node.isEndOfWord()) {
            completeWords.add(node.getContent());
        }
        for (Map.Entry<Character, TrieNode> charSequence : node.getChildren().entrySet()) {
            if (charSequence.getValue().isEndOfWord()) {
                completeWords.add(charSequence.getValue().getContent());
            }
            getCompleteWords(charSequence.getValue(), completeWords);
        }
    }
}
