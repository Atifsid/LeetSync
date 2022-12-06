class Solution {
    private int predFun(int mid, int nums[]){
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += Math.ceil((float)nums[i]/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 0, high = Integer.MIN_VALUE;
        for(int val : nums){
            high = Math.max(val, high);
        }
        while(low < high){
            int mid = low + ((high - low)/2);
            if(predFun(mid, nums) <= threshold){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}