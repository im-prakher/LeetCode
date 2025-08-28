class Solution {
    public long maximumTotalDamage(int[] power) {
        long max_dp = 0; int n = power.length;
        long dp[] = new long[100001];
        Arrays.sort(power);
        for(int i = 0, j = 0; i < n; i++) {
            if(power[i] == power[Math.max(0, i-1)]) {
                dp[i+1] = dp[i] + power[i];
            } else {
                while(power[j] + 2 < power[i]) {
                    max_dp = Math.max(max_dp, dp[++j]);
                }
                dp[i+1] = power[i] + max_dp;
            }
        }

        long ans = 0;
        for(long damage : dp) {
            ans = Math.max(ans, damage);
        }
        return ans;
    }
}