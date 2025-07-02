class Solution {
    public int atMost(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0, j = -1; i < nums.length; i++) {
            k -= nums[i] % 2 == 1 ? 1 : 0;
            while(k < 0) {
                k += nums[++j] % 2 == 1 ? 1 : 0;
            }
            cnt += i - j;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
}