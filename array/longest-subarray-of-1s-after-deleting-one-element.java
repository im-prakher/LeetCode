class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, ans = 0, len = 0, cnt = 0;
        for(int i = 0, j= 0; i < n; i++) {
            cnt += nums[i] == 0 ? 1 : 0;
            while(cnt > 1) {
                cnt -= nums[j++] == 0 ? 1 : 0;    
            }
            len = Math.max(len, i - j);
        }
        return len;
    }
}