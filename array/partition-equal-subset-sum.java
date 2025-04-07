class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;
        int target = sum >> 1, n = nums.length;
        boolean dp[] = new boolean[target+1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}