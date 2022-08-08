class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        // init board, fill it with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrace(res, board, 0);
        return res;
    }
    
    public void backtrace(List<List<String>> res, char[][] board, int r) {
        int n = board.length;
        if (r == n) {
            List<String> tmpRes = new ArrayList<>();
            for (char[] row : board) {
                String strRow = String.valueOf(row);
                tmpRes.add(strRow);
            }
            res.add(tmpRes);
        }
        for (int c = 0; c < n; c++) {
            if (isValid(board, r, c)) {
                board[r][c] = 'Q';
                backtrace(res, board, r + 1);
                board[r][c] = '.';
            }           
        }
    }
    
    // check if it's valid to put queen on row r and column c on board
    public boolean isValid(char[][] board, int r, int c) {
        if (r == 0) return true;
        // check above
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') return false;
        }
        // check up-left
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // if (c > 0 && board[r - 1][c - 1] == 'Q') return false;   // bug: check only one cell
        // check up-right
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}