import java.util.ArrayList;

//class Trie {
//
//    private char val;
//    //Trie root;
//    private Boolean isIn;
//    private ArrayList<Trie> children;
//
//    public Trie() {
//        isIn = false;
//        children = new ArrayList<Trie>();
//    }
//
//    private Trie(char c) {
//        val = c;
//        isIn = false;
//        children = new ArrayList<Trie>();
//    }
//
//    public void insert(String word) {
//        char[] chars = word.toCharArray();
//        Trie root = this;
//        for (char c : chars) {
//            if (root.children.size() == 0) {
//                Trie newTrie = new Trie(c);
//                root.children.add(newTrie);
//                root = newTrie;
//            }
//            for(int i = 0; i < root.children.size(); i++) {
//                if (root.children.get(i).val == c) {
//                    root = root.children.get(i);
//                    break;
//                }
//                if (i == root.children.size() - 1) {
//                    Trie newTrie = new Trie(c);
//                    root.children.add(newTrie);
//                    root = newTrie;
//                }
//            }
//
//        }
//        root.isIn = true;
//        //root = this;
//    }
//
//    public boolean search(String word) {
//        char[] chars = word.toCharArray();
//        Trie root = this;
//        for (int j = 0; j < chars.length; j++) {
//            for (int i = 0; i < root.children.size(); i++) {
//                if (root.children.get(i).val == chars[j]){
//                    if(root.children.get(i).isIn == true && j == chars.length - 1) {
//                        //root = this;
//                        return true;
//                    }
//                    else {
//                        root = root.children.get(i);
//                        break;
//                    }
//                }
//                if (i == root.children.size() - 1) {
//                    return false;
//                }
//            }
//        }
//        //root = this;
//        return false;
//    }
//
//    public boolean startsWith(String prefix) {
//        char[] chars = prefix.toCharArray();
//        Trie root = this;
//        for (char c : chars) {
//            if (root.children.size() == 0) return false;
//            for (int i = 0; i < root.children.size(); i++) {
//                if (root.children.get(i).val == c) {
//                    root = root.children.get(i);
//                    break;
//                }
//                if (i == root.children.size() - 1) {
//                    return false;
//                }
//            }
//        }
//        //root = this;
//        return true;
//    }
//
//    public static void main(String[] args) {
//         Trie obj = new Trie();
//         obj.insert("ab");
//        boolean param_2 = obj.search("abc");
//        boolean param_3 = obj.search("ab");
//         obj.insert("abc");
//        obj.insert("ab");
//        boolean param_4 = obj.search("abc");
//        boolean param_5 = obj.startsWith("abc");
//        obj.insert("abc");
//         boolean param_6 = obj.search("abc");
//
//
//    }
//}

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
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