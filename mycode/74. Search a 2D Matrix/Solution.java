class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
//         int i = 0;
//         int j = matrix.length - 1;
//         while (i < j) {
//             int mid = (i + j) / 2;
//             if (target == matrix[mid][0]) return true;
//             if (target < matrix[mid][0]) {
//                 j = mid - 1;
//             }
//             if (target > matrix[mid][0]) {
//                 i = mid + 1;
//             }
//         }
        
//         int row = i;
//         if (target < matrix[row][0]) row = i - 1;
//         if (row < 0) return false;
//         System.out.println(row);
//         i = 0; 
//         j = matrix[0].length - 1;
//         while (i <= j) {
//             int mid = (i + j) / 2;
//             if (target == matrix[row][mid]) return true;
//             if (target < matrix[row][mid]) j = mid - 1;
//             else if (target > matrix[row][mid]) i = mid + 1;
//         }
        
//         return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m * n - 1;
        // while (l <= r){
        //     int mid = (l + r) / 2;
        //     if (matrix[mid / m][mid % m] == target) return true;
        //     if (matrix[mid / m][mid % m] < target)
        //         l = mid + 1;
        //     else 
        //         r = mid - 1;
        // }
        // return false;
        
        while (l < r){
            int mid = (l + r) / 2;
            //if (matrix[mid / m][mid % m] == target) return true;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else 
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }
}