class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        char[] str = s.toCharArray();
        
        // char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        // int[] value = new int[]{1, 5, 10, 50, 100, 500, 1000};
        
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int[] values = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            values[i] = map.get(str[i]);
        }
        int res = 0;
        
        for (int i = 0; i < str.length - 1; i++) {
            if (values[i] < values[i + 1]) {
                res -= values[i];
            }
            else {
                res += values[i];
            }
        }
        res += values[values.length - 1];
        
        // int i = 0;
        // for (int j = 1; j < s.length(); i++, j++) {
        //     if (str[i] == 'I') {
        //         if (str[j] == 'V') res += 4;
        //         else if (str[j] == 'X') res += 9;
        //         else {
        //             res += 1;
        //             continue;
        //         }
        //         i++;j++;
        //     }
        //     else if (str[i] == 'X') {
        //         if (str[j] == 'L') res += 40;
        //         else if (str[j] == 'C') res += 90;
        //         else {
        //             res += 10;
        //             continue;
        //         }
        //         i++;j++;
        //     }
        //     else if (str[i] == 'C') {
        //         if (str[j] == 'D') res += 400;
        //         else if (str[j] == 'M') res += 900;
        //         else {
        //             res += 100;
        //             continue;
        //         }
        //         i++;j++;
        //     }
        //     else res += map.get(str[i]);
        // }
        // if (i < str.length) res += map.get(str[i]);
        return res;
    }
}