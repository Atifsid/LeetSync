class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i<haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(needle.equals(haystack.substring(i, needle.length()+i))){
                    return i;
                }
            }
        }
    return -1;
    }
}