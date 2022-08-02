class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        boolean rowV[] = new boolean[n];
        boolean dia[] = new boolean[2 * n - 1];
        boolean revDia[] = new boolean[2 * n - 1];
        solve(0, board, res, rowV, dia, revDia);
        return res;
    }
    
    static void solve(int col, char[][] board, List<List<String>> res, boolean rowV[], boolean dia[], boolean revDia[]){
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i<board.length; i++){
                    String s = new String(board[i]);
                    temp.add(s);
            }
            res.add(temp);
        }
        for(int row = 0; row<board.length; row++){
            if(rowV[row] == false && dia[row + col] == false && revDia[row - col + board.length - 1] == false){
                board[row][col] = 'Q';
                rowV[row] = true;
                dia[row + col] = true;
                revDia[row - col + board.length - 1] = true;
                solve(col+1, board, res, rowV, dia, revDia);
                board[row][col] = '.';
                rowV[row] = false;
                dia[row + col] = false;
                revDia[row - col + board.length - 1] = false;
            }
        }
    }
}