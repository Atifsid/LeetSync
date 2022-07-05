class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        
        for(int i=0; i<numRows; i++){
            row = new ArrayList<Integer>();
            for(int j =0; j<=i; j++)
                if(j==0 || j==i) //if it is first and last element of the list
                    row.add(1);
                else
                row.add(pre.get(j) + pre.get(j-1));
            pre = row;
            res.add(row);
        }
        return res;
    }
}