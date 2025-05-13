class Solution {
    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    public int maxProduct(int[] nums) {
        int currMin = nums[0], currMax = nums[0], ans = nums[0];
        for(int i = 1 ; i < nums.length; i++) {
            int tmp = nums[i] * min(1, currMin, currMax);
            currMax = nums[i] * max(1, currMin, currMax);
            currMin = tmp;
            ans = max(ans, currMin, currMax);
        }
        return ans;
    }
}