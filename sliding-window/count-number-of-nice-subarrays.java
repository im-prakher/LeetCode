class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt[] = new int[100_000];
        cnt[0] = 1;
        int odd = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            odd += (nums[i] % 2) == 1 ? 1 : 0;
            cnt[odd]++;
            res += (odd - k >= 0) ? cnt[odd-k] : 0;
        }
        return res;
    }
}