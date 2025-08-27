class Solution {
    public int solve(int nums[], int idx) {
        if(idx == nums.length)
            return 0;
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
        return Math.max(take + solve(nums, i), solve(nums, idx+1));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        return solve(nums, 0);
    }
}