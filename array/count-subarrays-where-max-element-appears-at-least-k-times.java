class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0; int n = nums.length;
        int max = Arrays.stream(nums).max().orElse(0);
        // long cnt = Arrays.stream(nums).filter(i->i==max).count();
        // if(cnt < k)
        //     return 0;
        long maxFreq= 0;
        for(int i = 0, j = 0; i < n; i++) {
            maxFreq += nums[i] == max ? 1 : 0;
            while(maxFreq == k) {
                ans += n - i;
                maxFreq -= nums[j++] == max ? 1 : 0;
            }
        }
        return ans;
    }
}