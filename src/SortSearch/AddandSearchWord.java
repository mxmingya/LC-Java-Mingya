package SortSearch;

/**
 * Created by mingyama on 10/19/17.
 */
public class AddandSearchWord {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        char val;
        public TrieNode(char c) {
            this.val = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public AddandSearchWord() {
        this.root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c-'a'] == null) {
                temp.children[c-'a'] = new TrieNode(c);
            }
            temp = temp.children[c-'a'];
        }
        temp.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c-'a'] == null) return false;
            temp = temp.children[c-'a'];
        }
        return temp.isWord;
    }
}
