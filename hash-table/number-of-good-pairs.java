class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        for(int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int ans = 0;
        for(int c : cnt) {
            ans += c * (c - 1);
        }
        return ans / 2;
    }
}