class Solution {
    public long minimumSteps(String s) {
        int n = s.length(), zero = n-1;
        long ans = 0;
        for(int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '1') {
                ans += zero - i;
                zero--;
            }
        }
        return ans;
    }
}