class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n]; // dp[i] represents maximum length of subsequence ending with nums[i]
        int cnt[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
               if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = 0;
                    }
                    if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        int ans = 0;
        for(int i= 0; i < n; i++) {
            if(max == dp[i])
                ans += cnt[i];
        }
        return ans;
    }
}