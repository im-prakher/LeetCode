  class Solution {
    // top down 
    public int solve(int[] nums, int idx, int prev) {
        if(idx == nums.length)
            return 0;
        int pick = 0;
        int no_pick = solve(nums, idx+1, prev);
        if(prev == -1 || nums[prev] < nums[idx]) 
            pick = 1 + solve(nums, idx+1, idx);
        return Math.max(pick, no_pick);
    }

    //bottom-up tabulation of above top-down approach
    public int solveTab(int[] nums) {
        int n = nums.length;
        // return solve(nums, 0, -1);
        int dp[][] = new int[n+1][n+1];
        for(int i = n-1; i >=0; i--) {
            for(int j = i-1; j >= -1; j--) {
                int no_pick = dp[i+1][j+1], pick = 0;
                if(j == -1 || nums[j] < nums[i])
                    pick = 1 + dp[i+1][i+1];
                dp[i][j+1] = Math.max(pick, no_pick);
            }
        }
        return dp[0][0];
    }

    //better optimal bottom-up appoach pure tabulation
    public int solveTab2(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n]; // dp[i] represents maximum length of subsequence ending with nums[i]
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // most optimal using binary search lower bound
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < n; i++) {
            int k = list.size()-1;
            if(nums[i] > list.get(k))
                list.add(nums[i]);
            else {
                int idx = lower_bound(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }

    public int lower_bound(List<Integer> list, int tag) {
        int i = 0, j= list.size()-1;
        while(i < j) {
            int mid = (i + j) >> 1;
            if(list.get(mid) == tag)
                return mid;
            else if(list.get(mid) < tag)
                i = mid + 1;
            else
                j = mid;
        }
        return i;
    }
}