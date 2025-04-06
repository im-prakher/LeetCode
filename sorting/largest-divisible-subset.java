class Solution {   
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[n];
        int[] hash = new int[n];
        for(int i = 0 ; i < n; i++)
            hash[i] = i;
        Arrays.fill(dp, 1);
        int mx = 0, k = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                    if(mx < dp[i]) {
                        mx = dp[i];
                        k = i;
                    }
                }
            }
        }
        while(hash[k] != k) {
            ans.add(nums[k]);
            k = hash[k];
        }
        ans.add(nums[k]);
        return ans;
    }
}