class Trie {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int cnt = 0;
    }
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode p = root;
        for (char w : word.toCharArray()) {
            if (p.children[w - 'a'] == null) {
                p.children[w - 'a'] = new TrieNode();
            }
            p = p.children[w - 'a'];
        }
        p.cnt++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode p = root;
        for (char w : word.toCharArray()) {
            if (p.children[w - 'a'] == null) {
                return 0;
            }
            p = p.children[w - 'a'];
        }
        return p.cnt;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode p = root;
        int sum = 0;
        for (char w : prefix.toCharArray()) {
            if (p.children[w - 'a'] == null) {
                return 0;
            }
            p = p.children[w - 'a'];
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(p);
        while (!q.isEmpty()) {
            TrieNode tmp = q.poll();
            sum += tmp.cnt;
            for (TrieNode child : tmp.children) {
                if (child != null) {
                    q.offer(child);
                }
            }            
        }
        return sum;

    }
    
    public void erase(String word) {
        TrieNode p = root;
        for (char w : word.toCharArray()) {
            if (p.children[w - 'a'] == null) {
                return;
            }
            p = p.children[w - 'a'];
        }
        p.cnt--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */