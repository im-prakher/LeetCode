class Solution {
    //kind of kadane's algo variation, max_diff so far
    public long maximumTripletValue(int[] nums) {
        long max = 0, diff = 0, ans= 0;
        for(int num : nums) {
            ans = Math.max(ans, diff * num);
            diff = Math.max(diff, max - num);
            max = Math.max(num, max);
        }
        return ans;
    }
}