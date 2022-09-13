class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int n: nums){
//             if(map.containsKey(n)){
//                 map.put(n, map.get(n) + 1);
//             }
//             else{
//                 map.put(n,1);
//             }
//         }
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
//         for(int key: map.keySet()){
//             pq.add(key);
            
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
//         int res[] = new int[k];
//         int i = 0;
//         while(pq.isEmpty() != true){
//             res[i++] = pq.poll();
//         }
//         return res;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }
            else{
                map.put(n,1);
            }
        }
        
        List<Integer>[] freqIndArr = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(freqIndArr[freq] == null){
                freqIndArr[freq] = new ArrayList<>();
            }
            freqIndArr[freq].add(key);
        }
        
        int res[] = new int[k];
        int count = 0;
        for(int i = freqIndArr.length - 1; i >= 0; i--){
            if(freqIndArr[i] != null){
                for(int j = 0; j<freqIndArr[i].size(); j++){
                    res[count++] = freqIndArr[i].get(j);
                }
            if(count == k) break;
            }
        }
    return res;
    }
}