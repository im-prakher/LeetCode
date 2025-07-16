class Solution {
    public int rob(int[] nums) {
        int a = nums[0], b = nums[1], c = Math.max(a, b);
        if (nums.length == 1)
            return a;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}