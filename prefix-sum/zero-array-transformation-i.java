class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n + 1];
        for(int[] qry : queries) {
            diff[qry[0]] += 1;
            diff[qry[1] + 1] -= 1;
        }
        for(int i = 1; i < n; i++) {
            diff[i] += diff[i-1];
            if(diff[i] < nums[i])
                return false;
        }
        return diff[0] >= nums[0];
    }
}