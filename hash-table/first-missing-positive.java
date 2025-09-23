class Solution {
    void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n)
                continue;
            int pos = nums[i]-1;
            swap(nums, pos, i);
            if(pos > i) 
                i--;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1)
                return i + 1;
        }
        return n+1;
    }
}