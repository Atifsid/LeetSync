class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxA = 0;
        int n = heights.length;
        int ls[] = new int[n];
        int rs[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        //Find out left smaller for every element.
        for(int i = 0; i<n; i++){
            while(st.empty() == false && heights[st.peek()] >= heights[i])
                st.pop();
            
            if(st.empty() == true) ls[i] = 0;
            else ls[i] = st.peek() + 1;
            st.push(i);
        }
        
        //Use same stack.
        while(st.empty() != true) st.pop();
        
        //Find out right smaller for every element.
        //Calculate MAX Area.
        for(int i=n-1; i>=0; i--){
            while(st.empty() == false && heights[st.peek()] >= heights[i])
                st.pop();
            
            if(st.empty() == true) rs[i] = n-1;
            else rs[i] = st.peek() -1;
            
            maxA = Math.max(maxA, heights[i] * (rs[i] - ls[i] +1));
            st.push(i);
        }
        
        return maxA;
    }
}