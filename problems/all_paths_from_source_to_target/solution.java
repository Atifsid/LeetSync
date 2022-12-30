class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path, graph, res);
        return res;
    }
    private void dfs(int src, List<Integer> path , int[][] graph, List<List<Integer>> res){
        if(src == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int n : graph[src]){
            path.add(n);
            dfs(n, path, graph, res);
            path.remove(path.size() - 1);
        }
    }
}