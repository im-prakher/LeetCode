class Solution {
    public long lower_bound_pairs(int[] nums, int val) {
        long cnt = 0;
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum >= val) {
                cnt += j - i;
                j--;
            } else {
                i++;
            }
        }
        return cnt;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound_pairs(nums, lower) - lower_bound_pairs(nums, upper + 1);
    }
}