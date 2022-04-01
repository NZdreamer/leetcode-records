class Solution {
//    public int maxProduct(int[] nums) {

    // method 1: O(n^2)
//         int res = nums[0];

//         for (int i = 0; i < nums.length; i++) {
//             int product = nums[i];
//             res = Math.max(res, product);
//             for (int j = i + 1; j < nums.length; j++) {
//                 product = product * nums[j];
//                 res = Math.max(res, product);
//             }

//         }
//         return res;


    // method 2: O(n)
    // Its all about having odd or even numbers of negative integers.
    // if the negative numbers are even, then the first pass will give the solution.
    // If the negative numbers are odd, the second pass will give the solution.
    int res = Integer.MIN_VALUE;

    int prod = 1;

        for (int i = 0; i < nums.length; i++) {
        prod = prod * nums[i];
        res = Math.max(res, prod);
        if (prod == 0) {
            prod = 1;
        }
    }

    prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
        prod *= nums[i];
        res = Math.max(res, prod);
        if (prod == 0) {
            prod = 1;
        }
    }

       return res;


    //}

    // public int maxProduct(int[] A) {
    //     int n = A.length, res = A[0], l = 0, r = 0;
    //     for (int i = 0; i < n; i++) {
    //         l =  (l == 0 ? 1 : l) * A[i];
    //         r =  (r == 0 ? 1 : r) * A[n - 1 - i];
    //         res = Math.max(res, Math.max(l, r));
    //     }
    //     return res;
    // }

    // method 3: dp
//     public int maxProduct(int[] nums) {
//         int res = nums[0];
//         int min = nums[0];
//         int max = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] < 0) {
//                 int tmp = max;
//                 max = min;
//                 min = tmp;
//             }
//             max = Math.max(max * nums[i], nums[i]);
//             min = Math.min(min * nums[i], nums[i]);
//             res = Math.max(max, res);   //
//         }

//         return res;
//     }



}