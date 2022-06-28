class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, maxSum = 0;
        
        for(int i = 0; i<k; i++){
            sum += cardPoints[i];
            maxSum = sum;
    }
        //if(k == cardPoints.length-1) return maxSum;
            
        for(int i = k-1, j=cardPoints.length-1; i>=0; i--, j--){
            sum += cardPoints[j] - cardPoints[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}