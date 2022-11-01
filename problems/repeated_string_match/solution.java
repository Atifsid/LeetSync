class Solution {
    public int repeatedStringMatch(String a, String b) {
        String temp = a;
        int ans = 1;
        while(a.length()<b.length()){
            a += temp;
            ans++;
        }

        if(a.indexOf(b) != -1){
            return ans;
        }
            
        if((a+temp).indexOf(b) != -1){
            return ans + 1;
        }
        
        return -1;
    }
}