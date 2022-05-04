class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        // start from each char on board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    // backtrack
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        // if already visited or not in the words list, return
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        // if is a word, add to res
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        
        // mark the current position, search for four directions on board
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        // unmark the current position
        board[i][j] = c;
    }
    
    // Trie
    // a TrieNode includes a next array of TrieNodes, can get next letter of words
    // string word is not null when the node is a word in words
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        // for all words, make a word in Trie
        for (String w : words) {
            // build a word from root
            TrieNode p = root;
            // for each letter in the word, get index in next, travel p to p.next[i]
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}