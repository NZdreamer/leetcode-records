class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String key = String.valueOf(ca);
            System.out.println(ca.toString());
            if (hm.containsKey(key)) {
                hm.get(key).add(s);
            }
            else {
                List<String> l = new ArrayList();
                l.add(s);
                hm.put(key, l);
            }
        }

        List<List<String>> res = new ArrayList(hm.values());

        return res;
    }
}