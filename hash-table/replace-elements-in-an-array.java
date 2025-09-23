class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int[] mp = new int[100_000];
        Arrays.fill(mp, -1);
        for(int i = 0; i < nums.length; i++) {
            mp[nums[i]] = i;
        }
        for(int[] ops : operations) {
            int idx = mp[ops[0]];
            nums[idx] = ops[1];
            mp[ops[0]] = -1;
            mp[ops[1]] = idx;
        }
        return nums;
    }
}