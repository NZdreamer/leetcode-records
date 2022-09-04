class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[][] boxset = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxset[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowset = new HashSet<>(); 
            HashSet<Character> colset = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (board[i][j] < '0' || board[i][j] > '9') return false;
                    if (rowset.contains(board[i][j])) return false;
                    rowset.add(board[i][j]);
                    char c = board[i][j];
                    if (boxset[i / 3][j / 3].contains(c)) return false;
                    boxset[i / 3][j / 3].add(c);
                }
                if (board[j][i] != '.') {
                    if (board[j][i] < '0' || board[j][i] > '9') return false;
                    if (colset.contains(board[j][i])) return false;
                    colset.add(board[j][i]);
                }
                
                
            }
        }
        
        // for (int j = 0; j < 9; j++) {
        //     HashSet<Character> colset = new HashSet<>(); 
        //     for (int i = 0; i < 9; i++) {
        //         if (colset.contains(board[i][j])) return false;
        //         colset.add(board[i][j]);
        //     }
        // }
        return true;
        
    }
}