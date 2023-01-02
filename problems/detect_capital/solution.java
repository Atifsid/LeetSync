class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if(len < 2) return true;
        int capitalCount = 0;

        for(int i = 0; i < len; i++){
            // ch is the ASCII value of char at i
            int ch = word.charAt(i);
            // check for capital letters
            if(ch >= 65 && ch <= 95) capitalCount++;
        }

        if(capitalCount == 0) return true; // no capital letters
        if(capitalCount == len) return true; // all capital letters
        // only starting letter is capital
        if(capitalCount == 1 && word.charAt(0) >= 65 && word.charAt(0) <= 95) return true;
        return false;
    }
}