class Solution {
    Map<String, Integer> dp;
    public int func(int[] nums, int idx, boolean state, int prev) {
        if(idx == nums.length)
            return 0;
        String key = String.valueOf(state) + "_" + idx + "_" + prev;
        if(dp.containsKey(key))
            return dp.get(key);
        int pick = 0, not_pick = 0;
        if(state && prev < nums[idx]) 
            pick = 1 + func(nums, idx + 1, !state, nums[idx]);
        else if(!state && prev > nums[idx])
            pick = 1 + func(nums, idx + 1, !state, nums[idx]);
        not_pick = func(nums, idx + 1, state, prev);
        int ans = Math.max(pick, not_pick);
        dp.put(key, ans);
        return ans;
    }

    public int wiggleMaxLength(int[] nums) {
        dp = new HashMap<>();
        return Math.max(func(nums, 0, true, -1), func(nums, 0, false, 1005));
    }
}
