class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j,temp = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(i=0; i<m; i++){
            if(matrix[i][0] == 0) temp = 0;
            
            for(j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        
        for(i=m-1; i>=0; i--){
            for(j=n-1; j>=1; j--){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        if(temp == 0) matrix[i][0] = 0;
        }
    }
}