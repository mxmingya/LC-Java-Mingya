package Tree;

/**
 * Created by mingyama on 10/19/17.
 */
public class Trie {

    /** Initialize your data structure here. */
    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        public TrieNode(char c) {
            this.val = c;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    TrieNode root;
    public Trie() {
        this.root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode inserter = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (inserter.children[c-'a'] == null) {
                TrieNode temp = new TrieNode(c);
                inserter.children[c-'a'] = temp;
            }
            inserter = inserter.children[c-'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode runner = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (runner.children[c-'a'] == null) return false;
            runner = runner.children[c-'a'];
        }
        return runner.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (runner.children[c-'a'] == null) return false;
            runner = runner.children[c-'a'];
        }
        return true;
    }
}
