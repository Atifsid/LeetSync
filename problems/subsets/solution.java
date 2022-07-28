class Solution {
    static List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList();
        if(nums==null || nums.length==0) return res;
        
        ArrayList<Integer> list = new ArrayList<>();
        subseq(0,list,nums,nums.length);
        
        return res;
    }
    
    static void subseq(int i, ArrayList<Integer> list, int arr[], int n){
        if(i==n){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        subseq(i+1, list,arr,n);
        list.remove(list.size()-1);
        
        subseq(i+1, list,arr,n);
    }
}