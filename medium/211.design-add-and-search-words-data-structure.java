/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 * [trie]
 */

// @lc code=start
class WordDictionary {
    WordDictionary[] children;
    boolean isWord;
    
    public WordDictionary() {
        children = new WordDictionary[26];
        isWord = false;
    }
    
    public void addWord(String word) {
        WordDictionary node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new WordDictionary();
            }
            node = node.children[idx];
        }
        
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word.toCharArray(), 0, this);
    }
    
    public boolean search(char[] chars, int index, WordDictionary startNode) {
        WordDictionary node = startNode;
        for (int i=index; i<chars.length; i++) {
            char c = chars[i];
            if (c == '.') {
                for (WordDictionary child : node.children) {
                    if (child != null && search(chars, i+1, child)) {
                        return true;
                    }
                }
                
                return false;
            } else {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
        }
        
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

