class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n + 1];
        for(int[] qry : queries) {
            diff[qry[0]] += 1;
            diff[qry[1] + 1] -= 1;
        }
        for(int i = 0; i < n; i++) {
            diff[i] += i != 0 ? diff[i-1] : 0;
            if(diff[i] < nums[i])
                return false;
        }
        return true;
    }
}