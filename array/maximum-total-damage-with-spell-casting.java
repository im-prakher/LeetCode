class Solution {
    public long solve(int nums[], int idx, Map<Integer, Long> dp) {
        if(idx == nums.length)
            return 0;
        if(dp.containsKey(idx))
            return dp.get(idx);
        int i = idx; long take = 0;
        for(i = idx; i < nums.length; i++) {
            if(nums[i] != nums[idx])
                break;
            take += nums[i];
        }
        for(; i < nums.length; i++) {
            if(nums[idx] + 1 == nums[i] || nums[idx] + 2 == nums[i]) 
                continue;
            break;
        }
        long ans = Math.max(take + solve(nums, i, dp), solve(nums, idx+1, dp));
        dp.put(idx, ans);
        return ans;
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        Map<Integer, Long> dp = new HashMap<>();
        return solve(power, 0, dp);
    }
}