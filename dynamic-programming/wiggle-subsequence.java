class Solution {
    //LIS DP
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int low[] = new int[n];
        int high[] = new int[n];
        for(int i = 0; i < n; i++) {
            low[i] = high[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    high[i] = Math.max(high[i], low[j] + 1);
                } else if(nums[j] > nums[i]) {
                    low[i] = Math.max(low[i], high[j] + 1);
                }
            }
        }
        return Math.max(high[n-1], low[n-1]);
    }
}
