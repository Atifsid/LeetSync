class Solution {
    public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
//         for(int i = 0; i<nums.length; i++){
//             pq.add(nums[i]);
//         }
//         int res = -1;
//         while(k != 0){
//             res = pq.peek();
//             pq.poll();
//             k--;
//         }
//         return res;
        
        
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        
        return qSelect(0, nums.length-1, nums, nums.length-k);
    }
    
    int qSelect(int left, int right, int arr[], int newK){
        int pivot = arr[right];
        int p = left;
        for(int i = left; i<right; i++){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                p++;
            }
        }
        int temp1 = arr[p];
        arr[p] = arr[right];
        arr[right] = temp1;
        
        if(p > newK) return qSelect(left, p - 1, arr, newK);
        else if(p < newK) return qSelect(p + 1, right, arr, newK);
        else return arr[p];
    }
}