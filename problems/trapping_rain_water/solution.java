class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftmax = 0, rightmax = 0;
        int res = 0;
        
        while(r >= l){  
            if(height[l] <= height[r]){ // Makes sure that right side has a value equal or greater than curr l.
                if(height[l] >= leftmax)
                    leftmax = height[l];
                else
                    res += leftmax - height[l];
                l++;
            }
            else { // if(a[l] >= a[r]) Makes sure that left side has a value equal or greater than curr r.
                if(height[r] >= rightmax)
                    rightmax = height[r];
                else
                    res += rightmax - height[r];
                r--;
            } 
        }
        return res;
    }
}