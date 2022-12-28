class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int val : piles){
            pq.add(val);
        }

        while(k-- > 0){
            int rocks = pq.poll();
            rocks -= Math.floor(rocks / 2);
            pq.add(rocks);
        }
        int sum = 0;
        while(!(pq.isEmpty())){
            sum += pq.poll();
        }

        return sum;
    }
}