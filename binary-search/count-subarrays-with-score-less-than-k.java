class Solution {
    public long countSubarrays(int[] nums, long k) {
        long cnt = 0, sum = 0;
        for(int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum * (i - j + 1) >= k) {
                sum -= nums[j++];
            }
            cnt += i - j + 1;
        }
        return cnt;
    }
}