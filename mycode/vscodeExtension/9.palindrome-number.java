import java.util.*;
/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> num = new ArrayList();
        while (x != 0) {
            int cur = x % 10;
            num.add(0, cur);
            x = x / 10;
        }

        for (int i = 0; i < num.size() / 2; i++) {
            if (num.get(i) != num.get(num.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
