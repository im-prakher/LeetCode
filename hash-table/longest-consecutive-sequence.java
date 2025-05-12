class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        Arrays.sort(nums);
        int cnt = 0, ans = 0, diff = nums[1] - nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i])
                continue;
            if(diff == nums[i] - nums[i-1])
                cnt++;
            else 
                cnt = 1;
            diff = nums[i] - nums[i-1];
            ans = Math.max(cnt, ans);
          }
        return ans + 1;
    }
}