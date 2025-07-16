class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int a = nums[0], b = nums[1], c = Math.max(a, b);
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(nums[i] + a, b);
            a = Math.max(a, b);
            b = c;
        }
        return c;
    }
}