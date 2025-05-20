class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int acc = 0, n = nums.length, qrySum = 0;
        for(int i : nums)  {
            acc += i;
        }
        int[] pre = new int[n+1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            pre[i] = sum;
            sum += nums[i] > 0 ? 1 : 0;
        }
        pre[n] = sum;
        int rightNeg = -1, leftNeg = n+1;
        for(int[] qry : queries) {
            int right = qry[1] >= rightNeg ? pre[qry[1]+1] - 1 : pre[qry[1]+1];
            int left = qry[0] <= leftNeg ? pre[qry[0]] - 1: pre[qry[0]];
            qrySum += right - left;
            rightNeg = Math.max(rightNeg, qry[1]);
            leftNeg = Math.min(leftNeg, qry[0]);
        }
        return acc <= qrySum; 
    }
}