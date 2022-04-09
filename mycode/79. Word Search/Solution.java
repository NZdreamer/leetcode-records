class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrace(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrace(char[][] board, String word, int idx, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res;
        res = backtrace(board, word, idx + 1, i + 1, j) || backtrace(board, word, idx + 1, i - 1, j) 
            || backtrace(board, word, idx + 1, i, j + 1) || backtrace(board, word, idx + 1, i, j - 1);
        board[i][j] = tmp;
        return res;
    }
}