class Solution {
    public int subarraySum(int[] nums, int k) {
        int cSum = 0;
        int result = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        h.put(0,1);

        for(int i : nums){
            cSum += i;
            
            if(h.containsKey(cSum - k))
                result += h.get(cSum - k);
                h.put(cSum, h.getOrDefault(cSum,0)+1);
        
        }
        return result;
        
    }
}

