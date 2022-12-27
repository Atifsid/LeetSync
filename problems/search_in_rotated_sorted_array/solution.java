class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid  = low + ((high - low) / 2);
            if(target == nums[mid]) return mid;
            
            // Check if left half is sorted
            if(nums[low] <= nums[mid]){
                // Check if element lies in the left half or not
                if(target >= nums[low] && target <= nums[mid]) high = mid - 1;
                else low = mid + 1;
                
            }
            // right half is sorted
            else{
                // Check if element lies in the right half or not
                if(target >= nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}