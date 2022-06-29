class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(i,j,0,board,word)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, int pos,char board[][], String word){
        
        if(word.length() == pos) return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(pos)) return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        
        boolean result = ( dfs(i-1, j, pos+1, board, word)  || 
                           dfs(i, j-1, pos+1, board, word)  ||
                           dfs(i+1, j, pos+1, board, word)  ||
                           dfs(i, j+1, pos+1, board, word) );
        
        board[i][j] = temp;
        
        return result;
        
    }
}