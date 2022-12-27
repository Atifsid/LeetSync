class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0;
        int i = 0;
        while(i < capacity.length && i < rocks.length){
            capacity[i] = capacity[i] - rocks[i];
            i++;
        }
        Arrays.sort(capacity);
        i = 0;
        // for(i = 0; i < capacity.length; i++){
        //     if(capacity[i] - additionalRocks <= 0){
        //         res++;
        //         additionalRocks -= capacity[i];
        //     }
        // }
        while(i < capacity.length){
            if(capacity[i] == 0) res++;
            else{
                if(additionalRocks >= capacity[i]){
                    res++;
                    additionalRocks -= capacity[i];
                }
                else{ 
                    break;
                }
            }
            i++;
        }
        return res;
    }
}