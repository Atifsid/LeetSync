class Solution {
    public static void gameOfLife(int[][] board) {
       
        int m = board.length;
        int n = board[0].length;
        
        //8 neighbour coordinates
        int x[] = {1,1,0,-1,-1,-1,0,1};
        int y[] = {0,-1,-1,-1,0,1,1,1};
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                
                int nei = 0;
                for(int k = 0; k<8 ; k++){
                    int cur_x = i + x[k], cur_y = j + y[k];
              
                    if( cur_x >= 0 && cur_y >= 0 && cur_x < m && cur_y < n && (Math.abs(board[cur_x][cur_y]) == 1 || board[cur_x][cur_y] == 3) ) {
                        nei += 1;
                    }
                }
                
    
                if(board[i][j] == 1){
                    if(nei < 2 || nei > 3)
                        board[i][j] = -1; //lives
                    else
                        board[i][j] = 3; //dies
                    
                }
                else { // if board[i][j] == 0
                    if(nei == 3)
                        board[i][j] = 2; //lives.
                }
            
            
            
        }
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 3 || board[i][j] == 2) board[i][j] = 1;
                else if(board[i][j] == -1) board[i][j] = 0;
                
            }
        }
    
    }
}