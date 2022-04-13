class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         return search(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
//     }
    
//     private boolean search(int[][] matrix, int il, int ih, int jl, int jh, int target) {
//         if (ih < 0 || jh < 0 || il >= matrix.length || jl >= matrix[0].length || il > ih || jl > jh) return false;
//         int im = (il + ih) / 2;
//         int jm = (jl + jh) / 2;
//         if (matrix[im][jm] == target) return true;
//         if (matrix[im][jm] < target) {
//             return search(matrix, im + 1, ih, jl, jh, target) 
//                 || search(matrix, il, ih, jm + 1, jh, target);
//         }
//         else return search(matrix, il, im - 1, jl, jh, target)
//             || search(matrix, il, ih, jl, jm - 1, target);
//     }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
        
    }
}