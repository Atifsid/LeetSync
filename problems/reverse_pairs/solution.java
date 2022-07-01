class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int a[], int low, int high){
        if(low >= high) return 0;
        
        int mid = (high + low) / 2;
        int rev = mergeSort(a, low, mid);
        rev += mergeSort(a, mid+1, high);
        rev += merge(a, low, mid, high);
            
        return rev;
    }
    
    private int merge(int a[], int low, int mid, int high){
        int count = 0;
        int j = mid+1;
        
        //reverse count process
        for(int i = low; i<=mid; i++){
            while(j<=high && (a[i] > 2*(long)a[j]))
                j++;
            count += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        
        while(left <= mid && right<= high){
            if(a[left] <= a[right])
                temp.add(a[left++]);
            else
                temp.add(a[right++]);
        }
        
        while(left<=mid)
            temp.add(a[left++]);
        
        while(right<=high)
            temp.add(a[right++]);
        
        for(int i=low; i<=high; i++)
            a[i] = temp.get(i-low);
            
        return count;
    }
}