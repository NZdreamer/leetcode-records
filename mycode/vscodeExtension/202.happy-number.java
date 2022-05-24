import java.util.HashSet;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> set = new HashSet();
        while (!set.contains(n)) {
            if (n == 1) return true;
            set.add(n);
            while (n != 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n = n / 10;
            }
            n = sum;
            sum = 0;            
        }
        return false;
    }
}
// @lc code=end

