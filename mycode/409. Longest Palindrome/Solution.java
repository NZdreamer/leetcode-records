class Solution {
//    public int longestPalindrome(String s) {
//        char[] str = s.toCharArray();
//        HashMap<Character, Integer> hm = new HashMap();
//        for (char c : str) {
//            hm.put(c, hm.getOrDefault(c, 0) + 1);
//        }
//
//        int res = 0;
//        int cnt1 = 0;
//        for (char c : hm.keySet()) {
//            if (hm.get(c) % 2 == 1) {
//                cnt1 = 1;
//            }
//
//            int pair = hm.get(c) / 2;
//            res = res + pair * 2;
//        }
//
//        return res + cnt1;
//    }

    public int longestPalindrome(String s) {
        char[] str = s.toCharArray();
        HashSet<Character> hs = new HashSet();
        int cnt = 0;
        for (char c : str) {
            if (hs.contains(c)) {
                hs.remove(c);
                cnt++;
            }
            else {
                hs.add(c);
            }
        }

        if (hs.isEmpty()) {
            return cnt * 2;
        }
        else return cnt * 2 + 1;
    }
}


