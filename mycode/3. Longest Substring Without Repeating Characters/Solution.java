class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int i = 0;
        int j = 0;
        int max = 0;
        
        while(j < s.length()) {
            char cur = s.charAt(j);
            if (!set.contains(cur)) {
                set.add(cur); 
                max = Math.max(max, j - i + 1);
                j++;
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }        
        return max;
    }
    
    // public int lengthOfLongestSubstring(String s) {
    //     Queue<Character> queue = new LinkedList<>();
    //     int res = 0;
    //     for (char c : s.toCharArray()) {
    //         // queue.contains() operation is O(N)
    //         while (queue.contains(c)) {
    //             queue.poll();
    //         }
    //         queue.offer(c);
    //         res = Math.max(res, queue.size());
    //     }
    //     return res;
    // }
}