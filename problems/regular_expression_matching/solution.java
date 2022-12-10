class Solution {
    public boolean isMatch(String s, String p) {
    // If the pattern is empty, the only way to match it is if the input string is also empty
    if (p.isEmpty()) return s.isEmpty();

    // Check if the first characters of the input string and the pattern match
    boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

    // If the second character of the pattern is a '*', we have two cases:
    // 1. The '*' matches zero characters of the input string. In this case, we can ignore the character
    //    and the '*' and check the remaining string and pattern.
    // 2. The '*' matches one or more characters of the input string. In this case, we can ignore the
    //    current character of the input string and check the remaining string and the same pattern.
    if (p.length() >= 2 && p.charAt(1) == '*') {
        return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
    }
    // If the second character of the pattern is not a '*', we just need to check if the first characters
    // of the input string and the pattern match, and then check the remaining string and pattern.
    else {
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
}