class Solution {
    public long minimumSteps(String s) {
        int n = s.length(), zero = 0;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '0') {
                ans += i - zero;
                zero++;
            }
        }
        return ans;
    }
}