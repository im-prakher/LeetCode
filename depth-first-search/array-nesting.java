class Solution {
    public int depth(int idx, int[] nums) {
        int depth = 0, strt = idx;
        while(nums[idx] != Integer.MAX_VALUE) {
            depth++;
            int pre = idx;
            idx = nums[idx];
            nums[pre] = Integer.MAX_VALUE;
        }
        return depth;
    }
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(ans == nums.length)
                break;
            if(nums[i]!=Integer.MAX_VALUE)
                ans = Math.max(ans, depth(i, nums));
        }
        return ans;
    }
}