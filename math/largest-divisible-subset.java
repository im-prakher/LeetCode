class Solution {   
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int k = 0, res = 0;
        for(int i = 0; i < n; i++) {
            hash[i] = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] <= dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            } 
            if(res < dp[i]) {
                res = dp[i];
                k = i;
            }
        }
        ans.add(nums[k]);
        while(hash[k] != k) {
            k = hash[k];
            ans.add(nums[k]);
        }
        return ans;
    }
}