class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for(int  i = 0; i < tasks.length; i++){
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0) +1);
        }
        int count = 0;
        for(int freq: freqMap.values()){
            if(freq == 1) return -1;
            else{
                count += (freq/3);
                if(freq % 3 != 0) count++;
            }
        }
    return count;
    }
}