class Solution {
    public int maxArea(int[] height) {
        int j = height.length - 1;
        int i = 0;
        int currMax = 0;
        
        while(j>i){
            int max = (j-i) * Math.min(height[i],height[j]);
            currMax = Math.max(max, currMax);
            
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return currMax;
    }
}