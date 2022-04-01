class MapSum {

    private TrieNode trie;

    class TrieNode {
        public int val;
        public TrieNode[] children;

        public TrieNode() {}
        public TrieNode(int val) {
            this.val = val;
        }
    }

    public MapSum() {
        trie = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = trie;
        char[] word = key.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if (node.children == null) node.children = new TrieNode[26];
            //TrieNode child = node.children[word[i] - 'a'];
            if (node.children[word[i] - 'a'] == null) {
                node.children[word[i] - 'a'] = new TrieNode(0);
                node = node.children[word[i] - 'a'];
            }
            else {
                node = node.children[word[i] - 'a'];
            }
            if (i == word.length - 1) node.val = val;
        }
    }

    public int sum(String prefix) {
        TrieNode node = trie;
        char[] word = prefix.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if (node.children == null) return 0;
            //TrieNode child = node.children[word[i] - 'a'];
            if (node.children[word[i] - 'a'] == null) return 0;
            else node = node.children[word[i] - 'a'];
        }
        return dfs(node) + node.val;
    }

    private int dfs(TrieNode node) {
        if (node == null) return 0;
        //if (node.children == null) return 0;
        int sum1 = 0;
        for (int i = 0; i < 26; i++) {
            if (node.children != null && node.children[i] != null){
                sum1 += node.children[i].val + dfs(node.children[i]);
            }
        }
        return sum1;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */