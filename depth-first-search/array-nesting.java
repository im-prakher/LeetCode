class Solution {
    public int depth(int idx, int[] nums) {
        int depth = 1, strt = idx;
        while(nums[idx] != strt) {
            depth++;
            idx = nums[idx];
        }
        return depth;
    }
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(ans == nums.length)
                break;
            ans = Math.max(ans, depth(i, nums));
        }
        return ans;
    }
}