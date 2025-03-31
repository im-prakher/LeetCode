class Solution {
    public long minimumSteps(String s) {
        int n = s.length(), zero = n-1;
        int pre[] = new int[n];
        for(int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '1') {
                pre[i] = zero - i;
                zero--;
            }
        }
        long ans = 0;
        for(int i : pre) 
            ans += i;
        return ans;
    }
}