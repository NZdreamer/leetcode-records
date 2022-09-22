/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    Trie[] children;
    boolean isWord;

    public Trie() {
        children = new Trie[26];
        isWord = false;
    }
    
    public void insert(String word) {
        Trie p = this;
        for (char w : word.toCharArray()) {            
            p = p.children[w - 'a'];
            if (p == null) p = new Trie();
        }
        p.isWord = true;
    }
    
    public boolean search(String word) {
        Trie p = this;
        for (char w : word.toCharArray()) {
            p = p.children[w - 'a'];
            if (p == null) return false;
        }
        return p.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie p = this;
        for (char c : prefix.toCharArray()) {
            p = p.children[c - 'a'];
            if (p == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

