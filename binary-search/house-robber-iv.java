class Solution {
    public boolean canRob(int[] nums, int cap, int k) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= cap) {
                i++;
                cnt++;
            }
        }
        return cnt >= k;
    }

    public int minCapability(int[] nums, int k) {
        int i = nums[0], j = nums[0];
        for(int n : nums) {
            i = Math.min(i, n);
            j = Math.max(j, n);
        }
        int ans = j;
        while(i < j) {
            int mid = (i + j) >> 1;
            if(canRob(nums, mid, k)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
}