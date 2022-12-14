class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int start = 1;
        int end = x;
        int res = 0;

        while(start <= end){
            int mid = start + (end-start)/2 ;
            if(mid * mid == x){
                res = mid;
                break;
            }
            else if(mid <= x/mid){
                start = mid + 1;
                res = mid;
            }
            else if(mid >= x/mid){
                end = mid - 1;
            }
        }
        return res;
    }
}