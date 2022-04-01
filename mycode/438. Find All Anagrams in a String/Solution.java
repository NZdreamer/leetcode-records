class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//        int[] pcnt = new int[26];
//        List<Integer> res = new ArrayList();
//
//        for (int i = 0; i < p.length(); i++) {
//            pcnt[p.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < s.length() - p.length() + 1; i++) {
//            int[] subcnt = new int[26];
//            for (int j = 0; j < p.length(); j++) {
//                subcnt[s.charAt(i + j) - 'a']++;
//            }
//
//            // if (Arrays.equals(pcnt, subcnt)) res.add(i);
//
//            boolean flag = true;
//            for (int k = 0; k < 26; k++) {
//                if (subcnt[k] != pcnt[k]) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (flag) res.add(i);
//        }
//
//        return res;
//    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length()) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }
}