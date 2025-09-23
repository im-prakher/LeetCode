class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] < 0 ? 0 : nums[i];
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0 || nums[i] > n)
                continue;
            int pos = Math.abs(nums[i]) - 1;
            if(nums[pos] > 0)
                nums[pos] = -nums[pos];
            if(nums[pos] == 0)
                nums[pos] = -1;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] >= 0) 
                return i + 1;
        }
        return n + 1;
    }
}