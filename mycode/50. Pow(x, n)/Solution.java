class Solution {
    public double myPow(double x, int n) {
        // if (x == 0) return 0;
        // if (x == 1) return 1;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == Integer.MIN_VALUE) return 1/ x * myPow(1 / x, - n - 1);
        if (n < 0) return myPow(1 / x, -n);
        if (n % 2 == 1) return x * myPow(x, n - 1);
        return myPow(x * x, n / 2);
    }
    
}