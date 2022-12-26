class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = firstIndx(nums, target);
        res[1] = lastIndx(nums, target);
        return res;
    }
    int firstIndx(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int indx = -1;
        while(low <= high){
            int mid = low + ((high - low)/ 2);
            if(nums[mid] == target){
                indx = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return indx;
    }

    int lastIndx(int[] nums, int target){
        int indx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + ((high - low)/ 2);
            if(nums[mid] == target){
                indx = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return indx;
    }
}