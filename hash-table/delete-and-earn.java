class Solution {
    public int solve(int nums[], int idx, Map<Integer, Integer> dp) {
        if(idx == nums.length)
            return 0;
        if(dp.containsKey(idx))
            return dp.get(idx);
        int i = idx, take = 0;
        for(i = idx; i < nums.length; i++) {
            if(nums[i] != nums[idx])
                break;
            take += nums[i];
        }
        for(; i < nums.length; i++) {
            if(nums[idx] + 1 != nums[i]) 
                break;
        }
        int ans = Math.max(take + solve(nums, i, dp), solve(nums, idx+1, dp));
        dp.put(idx, ans);
        return ans;
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        return solve(nums, 0, dp);
    }
}