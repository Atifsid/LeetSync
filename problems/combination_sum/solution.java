class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0, candidates, target, res, new ArrayList<>());
        return res;
    }
    
    private void findCombinations(int ind, int arr[], int target, List<List<Integer>> res, List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        // Pick
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], res, ds);
            ds.remove(ds.size() - 1);
        }
        // Not Pick
        findCombinations(ind+1, arr, target, res, ds);
    }
}