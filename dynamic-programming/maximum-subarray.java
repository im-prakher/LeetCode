class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for(int i : nums) {
            sum = i + Math.max(0, sum);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}