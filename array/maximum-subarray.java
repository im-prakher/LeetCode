class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for(int i : nums) {
            sum += i;
            sum = Math.max(sum, i);
            maxSum = Math.max(maxSum , sum);
        }
        return maxSum;
    }
}