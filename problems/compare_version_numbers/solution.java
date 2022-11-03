class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n1 = 0, n2 = 0;
        int v1L = version1.length();
        int v2L = version2.length();
        
        while(i < v1L || j < v2L){
            n1 = 0;
            n2 = 0;
            while(i < v1L && version1.charAt(i) != '.'){
                n1 = n1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while(j < v2L && version2.charAt(j) != '.'){
                n2 = n2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if(n1 > n2) return 1;
            else if(n1 < n2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}