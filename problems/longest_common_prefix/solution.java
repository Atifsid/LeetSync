class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;
        String res = "";
        while(i < s1.length() && i < s2.length()){
            if(s1.charAt(i) != s2.charAt(i)) break;
            res = res + s1.charAt(i);
            i++;
        }
        return res;
    }
}

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         String res = strs[0];
        
//         for(int i = 1; i< strs.length; i++){
//             res = find(res, strs[i]);
//         }
        
//         return res;
//     }
    
//     String find(String s1, String s2){
//         int i = 0;
//         String res = "";
//         while(i < s1.length() && i < s2.length()){
//             if(s1.charAt(i) != s2.charAt(i)) break;
//             res = res + s1.charAt(i);
//             i++;
//         }
//         return res;
//     }
// }