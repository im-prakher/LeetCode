class Solution {
    //LIS DP
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int low, high;
        low = high = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]) {
                high = low + 1;
            } else if(nums[i] < nums[i-1]) { 
                low = high + 1;
            }
        }
        return Math.max(high, low);
    }
}
