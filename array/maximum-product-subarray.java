class Solution {
    public int maxProduct(int[] nums) {
     int left = 1, curr = 1, ans = nums[0], right = 1, n = nums.length;
        for(int i = 0; i < n; i++) {
            left *= nums[i];
            right *= nums[n-i-1];
            ans = Math.max(ans, Math.max(left, right));
        }
        return ans;
    }
}