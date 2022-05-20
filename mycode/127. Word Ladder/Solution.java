class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Set<String> visited = new HashSet();
        Set<String> words = new HashSet();
        for (String word : wordList) {
            words.add(word);
        }
        Queue<String> q = new LinkedList();
        int depth = 1;
        
        q.add(beginWord);
        //visited.add(beginWord);
        if (words.contains(beginWord)) words.remove(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return depth;
                }
                // for (String word : wordList) {
                //     if (!visited.contains(word) && isAdj(word, cur)){   //
                //         q.add(word);
                //         visited.add(word);
                //     }
                // }
                
                // java.util.ConcurrentModificationException
                // cannot Remove Elements from a HashSet while Iterating
                // for (String word : words) {
                //     if (isAdj(word, cur)){
                //         q.add(word);
                //         words.remove(word);
                //     }
                // }
                char[] wordCa=  cur.toCharArray();
                for (int k = 0; k < cur.length(); k++) {
                    char t = wordCa[k];
                    for (int j = 0; j < 26; j++) { 
                        wordCa[k] = (char)('a' + j);
                        //String adjWord = new String(wordCa);
                        String adjWord = String.valueOf(wordCa);
                        if (words.contains(adjWord)) {
                            q.add(adjWord);
                            words.remove(adjWord);
                        }                        
                        wordCa[k] = t;
                    }
                }
            }
            depth++;
        }        
        return 0;
    }
    
    // private boolean isAdj(String w1, String w2) {
    //     int cnt = 0;
    //     for (int i = 0; i < w1.length(); i++) {
    //         if (cnt > 1) return false;
    //         if (w1.charAt(i) != w2.charAt(i)) cnt++;
    //     }
    //     return cnt == 1;
    // }
    
}