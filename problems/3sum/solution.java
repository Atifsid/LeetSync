class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - nums[i];
            
            while(high > low){
                if(nums[low] + nums[high] == sum){
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    
                    while(high > low && nums[low] == nums[low+1]) low++;
                    while(high > low && nums[high] == nums[high-1]) high--;
                    
                    low++;
                    high--;
                }
                else if(nums[low] + nums[high] < sum) low++;
                
                else high--;
            }
            }
        }
        return list;
    }
}