class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        while(top<=bottom && left <= right){
           
            if(dir == 0){ //move left to right
                for(int i=left; i<=right; i++)
                    arrList.add(matrix[top][i]);
                top++; //increase top pointer by as one top row is already traversed.
            }
            
            else if(dir == 1){ //move top to bottom
                for(int i=top; i<=bottom; i++)
                    arrList.add(matrix[i][right]);
                right--; //decrease right pointer by one as right column is already traversed.
            }
            
            if(dir == 2){ //move right to left
                for(int i=right; i>=left; i--)
                    arrList.add(matrix[bottom][i]);
                bottom--;  //decrease bottom pointer by one as bottom row is already traversed.
            }
            
            else if(dir == 3){ //move bottom to top
                for(int i=bottom; i>=top; i--)
                    arrList.add(matrix[i][left]);
                left++; //increase left pointer by as one left column is already traversed.
            }
            
            //dir = 0 initially. (move left to right)
            //dir = 1 % 4 = 1 (move top to bottom)
            //dir = 2 % 4 = 2 (move right to left)
            //dir = 3 % 4 = 3 (move bottom to top)
            
            dir = (dir+1) % 4; //guide directions.
        }
        return arrList;
    }
}