class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length - 1 == 0) return 0;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(mid > 0 && mid < nums.length - 1){
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] < nums[mid - 1]){
                high = mid - 1;
            }
            else if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            }
            else if(mid == 0){
                if(nums[mid] < nums[mid + 1]) return mid + 1;
                else return mid;
            }
            else if(mid == nums.length - 1){
                if(nums[mid] < nums[mid - 1]) return mid - 1;
                else return mid;
            }
        }
        return -1;
    }
}