class Solution {
    public long continuousSubarrays(int[] nums) {
        long cnt = 0;
        int mx = 0, mn = 0;
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(Math.abs(nums[mx]-nums[i]) > 2 
                    || Math.abs(nums[mn]-nums[i]) > 2) {
               j++;   
               mx = mx < j ? j : mx;
               mn = mn < j ? j : mn;
            }
            mx = nums[mx] < nums[i] ? i : mx;
            mn = nums[mn] > nums[i] ? i : mn;
            cnt += i - j + 1;
        }
        return cnt;
    }
}