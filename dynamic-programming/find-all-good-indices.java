class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
             List<Integer> ans = new ArrayList<>();
        int n = nums.length, days = 0;
        int[] inc = new int[n];
        int[] dec = new int[n];
        for(int i = 1, j = n-2; i < n && j >= 0; i++, j--) {
            if(nums[i-1] >= nums[i])
                inc[i] = inc[i-1] + 1;
            if(nums[j] <= nums[j+1])
                dec[j] = dec[j+1] + 1;
        }
        for(int i = k ; i < n-k; i++) {
            if(inc[i] >= k && k <= dec[i])
                ans.add(i);
        }
        return ans;
    }
}