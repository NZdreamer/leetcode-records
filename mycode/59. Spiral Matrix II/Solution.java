class Solution {
    public int[][] generateMatrix(int n) {
        int counter = 1;
        int[][] res = new int[n][n];

        int offset = 0;        
        int i = 0, j = 0;
        
        while (offset <= n / 2) {
            i = offset;
            j = offset;
            
            for (; j < n - offset - 1; j++) {
                res[i][j] = counter++;
            }
            for (; i < n - offset - 1; i++) {
                res[i][j] = counter++;
            }
            for (; j > offset; j--) {
                res[i][j] = counter++;
            }
            for (; i > offset; i--) {
                res[i][j] = counter++;
            }
            offset++;
        }
        
        if (n % 2 == 1) res[i][j] = counter;
        
        return res;
    }
}