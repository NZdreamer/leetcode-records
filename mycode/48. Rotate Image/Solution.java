class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    public void swap(int[][] matrix, int ai, int aj, int bi, int bj) {
        int tmp = matrix[ai][aj];
        matrix[ai][aj] = matrix[bi][bj];
        matrix[bi][bj] = tmp;
    }
}