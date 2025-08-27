class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;
        int ans = 0;
        for(int i  = 1, j = 0; i < nums.length-1; i++) {
            if(nums[i]-nums[i-1] == nums[i+1]-nums[i]) {
                ans += i - j;
            } else {
                j = i;
            }
        }
        return ans;
    }
}