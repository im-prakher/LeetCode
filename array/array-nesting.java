class Solution {
    public int depth(int idx, int[] nums, boolean[] vis) {
        int depth = 1, strt = idx;
        while(nums[idx] != strt) {
            depth++;
            idx = nums[idx];
            vis[idx] = true;
        }
        return depth;
    }
    public int arrayNesting(int[] nums) {
        int ans = 0;
        boolean[] vis = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(ans == nums.length)
                break;
            if(!vis[i])
                ans = Math.max(ans, depth(i, nums, vis));
        }
        return ans;
    }
}