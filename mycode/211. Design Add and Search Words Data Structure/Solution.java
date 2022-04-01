
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) p.children[c - 'a'] = new TrieNode();
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int i, String word, TrieNode root) {
        //if (root == null) return false;
        if (i == word.length()) return root.isWord;

        //boolean res = false;
        if (word.charAt(i) == '.') {
            for (int j = 0; j < 26; j++) {
                if (root.children[j] != null && dfs(i + 1, word, root.children[j])) {
                    //res = res || dfs(j + 1, word, root.children[j]);
                    return true;
                }
            }
            // return res;
        }
        else {
            if (root.children[word.charAt(i) - 'a'] == null) return false;
            else return dfs(i + 1, word, root.children[word.charAt(i) - 'a']);
        }

        return false;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */