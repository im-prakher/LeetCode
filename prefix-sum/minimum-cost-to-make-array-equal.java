class Solution {
    public long abs(long num) {
        return Math.abs(num);
    }
    public long minCost(int[] nums, int[] cost) {
        long sum = 0, nat_sum = 0, mul_sum = 0, tml_sum = 0, k = 1;
        int n = nums.length;
        int[][] conv = new int[n][2];
        for(int i = 0; i < n; i++) {
            conv[i][0] = nums[i];
            conv[i][1] = cost[i];
            tml_sum += nums[i] * cost[i];
            nat_sum += cost[i];
        }
        Arrays.sort(conv, (a, b)-> a[0] - b[0]);
        long ans = tml_sum;
        for(int[] cov : conv) {
            mul_sum += cov[0] * cov[1];
            sum += cov[1];
            long res = abs(mul_sum - cov[0] * sum) + abs(tml_sum - cov[0] * nat_sum);
            ans = Math.min(ans, res);
            tml_sum -= cov[0] * cov[1];
            nat_sum -= cov[1];
            k++;
        }
        return ans;
    }
}