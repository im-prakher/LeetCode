class Solution {
    int solve(String s, Map<String, Integer> dp) {
        if(dp.containsKey(s))
            return dp.get(s);
        if(s.length() == 0)
            return 1;
        if(s.charAt(0) == '0')
            return 0;
        int ways = 0;
        if(s.length() >=2 && Integer.valueOf(s.substring(0, 2)) < 27) {
            ways += solve(s.substring(2), dp);
        } 
        ways += solve(s.substring(1), dp);
        dp.put(s, ways);
        return ways;
    }
    public int numDecodings(String s) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(s, dp);
    }
}