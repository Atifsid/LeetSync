class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(0, nums, res);
        return res;
    }
    private void f(int index, int [] nums, List<List<Integer>> res){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<nums.length; i++){
                temp.add(nums[i]);
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i<nums.length; i++){
            swap(index, i ,nums);
            f(index+1, nums, res);
            swap(index, i, nums);
        }
    }
    private void swap(int i, int j, int a[]){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}