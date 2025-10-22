class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
             List<Integer> ans = new ArrayList<>();
        int n = nums.length, days = 0;
        long[] inc = new long[n];
        long[] dec = new long[n];
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        for(int i = 1, j = n-2; i < n && j >= 0; i++, j--) {
            if(nums[i-1] >= nums[i])
                inc[i] = inc[i-1] + 1;
            if(nums[j] <= nums[j+1])
                dec[j] = dec[j+1] + 1;
        }
        for(int i = 0; i < n; i++) {
            if(inc[i] == 0)
                inc[i] = 1;
            if(dec[i] == 0)
                dec[i] = 1;
        }
        for(int i = k ; i < n-k; i++) {
            if(inc[i-1] >= k && dec[i+1] >= k)
                ans.add(i);
        }
        return ans;
    }
}