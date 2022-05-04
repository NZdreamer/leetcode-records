class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        
        List<Integer> res = new LinkedList();
        
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            
        }
        //res.add(matrix[top][left]);
        
        return res;
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        
        int size = matrix.length * matrix[0].length;
        
        List<Integer> res = new LinkedList();
        
        while (res.size() < size) {
            for (int i = left; i <= right && res.size() < size; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom && res.size() < size; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            
            //if (top <= bottom) {
                for (int i = right; i >= left && res.size() < size; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
           // }
            
           // if (left <= right) {
                for (int i = bottom; i >= top && res.size() < size; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
          //  }
            
        }
        //res.add(matrix[top][left]);
        
        return res;
    }
}