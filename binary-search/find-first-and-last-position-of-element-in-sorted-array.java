class Solution {
    public int findIdx(int[] nums, int target, String str){
        int lo=0, hi = nums.length -1, idx =-1;       
        while(lo <= hi){
            int md = (lo + hi) / 2;
            boolean condition = str == "first" ? nums[md] >= target : nums[md] > target;
            if(nums[md] == target)
                idx = md;
            if(condition)
                hi = md - 1;
            else
                lo = md + 1;
        }
        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findIdx(nums, target, "first");
        ans[1] = findIdx(nums, target, "last");
        return ans;
    }
}