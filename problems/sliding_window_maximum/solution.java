class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res [] = new int[n - k + 1];
        int j = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            
            if(!q.isEmpty() && q.peek() == i - k){ // remove index out of bound for k size window
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){ // remove smaller values within k range
                q.pollLast();
            }
            
            q.offer(i);
            if(i >= k - 1){
                res[j++] = nums[q.peek()];
            }
        }
        return res;
    }
}