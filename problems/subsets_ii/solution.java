class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        f(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    void f(int ind, int arr[], ArrayList<Integer> temp, List<List<Integer>> res){      
        for(int i = ind; i<arr.length; i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            temp.add(arr[i]);
            f(i+1, arr, temp, res);
            temp.remove(temp.size()-1);
        }
        res.add(new ArrayList<>(temp));
    }
}