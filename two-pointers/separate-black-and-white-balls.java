class Solution {
    public long minimumSteps(String s) {
        int n = s.length(), zero = n-1;
        int pre[] = new int[n];
        char str[] = s.toCharArray();
        for(int i = n-1; i >= 0; i--) {
            if(str[i] == '1') {
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