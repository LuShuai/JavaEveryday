package datastructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuailu on 8/3/15.
 */
public class TrieNode {
    public char letter;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        this('\0');
    }

    public TrieNode(char letter) {
        this.letter = letter;
        children = new HashMap<Character, TrieNode>();
    }
}
