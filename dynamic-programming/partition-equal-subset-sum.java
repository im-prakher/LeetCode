class Solution {
    // solve() {
    //     if(tg == 0)
    //         true;
    //     if(nums[i] <= tg)
    //         solve(i-1, tg-nums[i]);
    //     solve(i-1, tg);
    // }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;
        int target = sum / 2, n = nums.length;
        boolean dp[] = new boolean[target+1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = nums[i]; j <= target; j++) {
                // if(nums[i] <= j)
                    dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}