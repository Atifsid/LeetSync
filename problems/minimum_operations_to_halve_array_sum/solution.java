class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
        double sum = 0;

        for(int val : nums){
            sum += val;
            pq.add((double)val);
       }
       int op = 0;
       double halfSum = sum / 2;
       while(sum > halfSum){
           double num = (pq.poll()) / 2.0;
           sum -= num;
           pq.add(num);
           op++;
       }

       return op;
    }
}