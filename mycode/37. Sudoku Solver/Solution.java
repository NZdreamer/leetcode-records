class Solution {
    public void solveSudoku(char[][] board) {
        backtrace(board, 0);
    }
    
    public boolean backtrace(char[][] board, int loc) {
        int row = loc / 9;
        int col = loc % 9;
        if (row > 8) {  // !!! was (row == 8 && col == 8), the last one didn't fill
            return true;
        }
        if (board[row][col] != '.') {
            return backtrace(board, loc + 1);   // !!! should return backtrace, instead of call backtrace and then return false
            // return false;
        }
        for (char c = '1'; c <= '9'; c++) { // !!! c from '1' to '9' inclusive ,not from '0'
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (backtrace(board, loc + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }            
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
            if (board[k][j] == c) return false;
            if (board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == c) return false;
        }
        return true;
    }
}