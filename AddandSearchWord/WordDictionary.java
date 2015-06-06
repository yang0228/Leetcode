/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

click to show hint.

You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/


public class WordDictionary {

private static final char WILDCARD = '.';

private final TrieNode root = new TrieNode();

// Adds a word into the data structure.
public void addWord(String word) {

    insert(root, word);
}

// Returns if the word is in the data structure. A word could
// contain the dot character '.' to represent any one letter.
public boolean search(String word) {

    return search(root, word, 0);
}

private void insert(TrieNode root, String word) {

    TrieNode node = root;
    for(int ind = 0; ind < word.length(); ind++) {
        final char c = word.charAt(ind);
        if(!node.next.containsKey(c)) {
            node.next.put(c, new TrieNode());
        }
        node = node.next.get(c);
    }
    node.isWordEnd = true;
}

private boolean search(TrieNode node, String word, int len) {

    if(node == null) {
        return false;
    }
    if(len == word.length()) {
        return node.isWordEnd;
    }
    final char c = word.charAt(len);
    if(isWildcard(c)) {
        for(TrieNode next : node.next.values()) {
            if(search(next, word, len + 1)) {
                return true;
            }
        }
        return false;
    } else {
        return search(node.next.get(c), word, len + 1);
    }
}

private boolean isWildcard(char c) {
    return c == WILDCARD;
}

private static class TrieNode {

    private final Map<Character, TrieNode> next = new HashMap<>();
    private boolean isWordEnd;
}
}