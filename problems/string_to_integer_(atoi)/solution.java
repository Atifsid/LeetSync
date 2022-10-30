class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int neg = 1;
        int res = 0;
        
        // remove leading whitespaces
        while(i < s.length() && s.charAt(i) == ' '){ 
            i++;
        }
        
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            neg = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int digit = s.charAt(i) - '0';
            
            if(res > Integer.MAX_VALUE / 10 || 
              res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)
            {
                return (neg == -1) ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            
            res = res * 10 + digit;
            i++;
        }
       
        return res*neg;
    }
}