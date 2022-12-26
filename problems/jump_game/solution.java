class Solution {
    public boolean canJump(int[] nums) {
        int r = 0;
        for(int i = 0; i<nums.length; i++){
            if(r < i) return false;
            r = Math.max(r, nums[i] + i);
        }
        return true;
    }
}