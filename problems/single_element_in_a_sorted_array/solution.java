class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(mid % 2 == 0){ // check if mid is even
                if(nums[mid] == nums[mid+1]){ // check if mid is in left half
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            else{ // mid is not in left half
                if(nums[mid] == nums[mid-1]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}