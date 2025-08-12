class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 1;
        if(s.charAt(0) == '0')
            return 0;
        int ways = 0;
        if(s.length() >=2 && Integer.valueOf(s.substring(0, 2)) < 27) {
            ways += numDecodings(s.substring(2));
        } 
        ways += numDecodings(s.substring(1));
        return ways;
    }
}