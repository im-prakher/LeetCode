class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i : nums) {
            int base = (int) Math.log10(i);
            ans += base & 1;
        }
        return ans;
    }
}