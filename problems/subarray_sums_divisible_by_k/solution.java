class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int cumulativeSum = 0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            cumulativeSum += nums[i];
            int remainder = cumulativeSum % k;
            
            if(remainder < 0) remainder += k;
            if(map.containsKey(remainder)){
                result += map.get(remainder);
                map.put(remainder, map.get(remainder) + 1);
            }
            else map.put(remainder,1);
        }
        return result;
    }
}