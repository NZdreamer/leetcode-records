class Solution {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        String res = "";

        int[] a = new int[128];
        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i)]++;
        }

        int start = 0;
        int count = t.length();
        for (int end = 0; end < s.length(); end++) {
            if (a[s.charAt(end)] > 0) count--;
            a[s.charAt(end)]--;

            while (count == 0 && start <= end) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    res = s.substring(start, end + 1);
                }
                a[s.charAt(start)]++;
                if (a[s.charAt(start)] > 0) count++;
                start++;
            }

        }
        return res;
    }


}