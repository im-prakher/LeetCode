class Solution {
    //LIS DP
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int low[] = new int[n];
        int high[] = new int[n];
        low[0] = high[0] = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]) {
                high[i] = low[i-1] + 1;
                low[i] = low[i-1];
            } else if(nums[i] < nums[i-1]) { 
                low[i] = high[i-1] + 1;
                high[i] = high[i-1];
            } else {
                low[i] = low[i-1];
                high[i] = high[i-1];
            }
        }
        return Math.max(high[n-1], low[n-1]);
    }
}
