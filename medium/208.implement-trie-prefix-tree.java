/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)\
 * [trie]
 */

// @lc code=start
class Trie {

    /** Initialize your data structure here. */
    // TrieNode root;
    boolean isEnd = false;
    Trie[] children;
    public Trie() {
        // root = new TrieNode();
        isEnd = false;
        children = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }

        node.isEnd = true;


        // TrieNode node = root;

        // for (int i=0; i<word.length(); i++) {
        //     int c = word.charAt(i) - 'a';
        //     if (node.children[c] == null) {
        //         node.children[c] = new TrieNode();
        //     }

        //     node = node.children[c];
        //     node.preCount++;
        // }

        // node.count++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // TrieNode node = root;
        // for (int i=0; i<word.length(); i++) {
        //     int c = word.charAt(i) - 'a';
        //     if (node.children[c] == null) {
        //         return false;
        //     }

        //     node = node.children[c];
        // }

        // return node.count > 0;
        Trie node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }

        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // TrieNode node = root;
        // for (int i=0; i<prefix.length(); i++) {
        //     int c = prefix.charAt(i) - 'a';
        //     if (node.children[c] == null) {
        //         return false;
        //     }

        //     node = node.children[c];
        // }

        // return node.preCount > 0;
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }

        return true;
    }

    // class TrieNode {
    //     TrieNode[] children;
    //     int count = 0;
    //     int preCount = 0;

    //     TrieNode() {
    //         children = new TrieNode[26];
    //         count = 0;
    //         preCount = 0;
    //     }
    // }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

