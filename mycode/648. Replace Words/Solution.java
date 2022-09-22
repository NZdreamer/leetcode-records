class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            String succ = trie.successor(w);
            sb.append(succ);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class Trie {
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
        p.isWord = true;
    }
    
    public String successor(String word) {
        TrieNode p = root;
        char[] ca = word.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (p.children[ca[i] - 'a'] != null) {
                if (p.children[ca[i] - 'a'].isWord) {
                    return word.substring(0, i + 1);
                }
                else {
                    p = p.children[ca[i] - 'a'];
                }
            }
            else {
                return word;
            }
        }
        return word;
    }
}
