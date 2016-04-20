package datastructure.trie;

import java.util.Map;

/**
 * Created by shuailu on 8/3/15.
 */


public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode parent = root;
        char[] charArr = word.toCharArray();
        for (int n = 0; n < charArr.length; n++) {
            Map<Character, TrieNode> currentMap = parent.children;
            if (!currentMap.containsKey(charArr[n])) {
                currentMap.put(charArr[n], new TrieNode(charArr[n]));
            }
            parent = currentMap.get(charArr[n]);
        }
        parent.children.put('\0', null);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode last = walkTo(word);
        if (last == null) {
            return false;
        }
        return last.children.containsKey('\0');
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return (walkTo(prefix) != null);
    }

    private TrieNode walkTo(String prefix) {
        TrieNode parent = root;
        char[] charArr = prefix.toCharArray();
        for (int n = 0; n < charArr.length; n++) {
            Map<Character, TrieNode> currentMap = parent.children;
            if (!currentMap.containsKey(charArr[n])) {
                return null;
            }
            parent = currentMap.get(charArr[n]);
        }
        return parent;
    }

}



// Your trie object will be instantiated and called as such:
// trie trie = new trie();
// trie.insert("somestring");
// trie.search("key");



