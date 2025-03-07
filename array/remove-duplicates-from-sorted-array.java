class Solution {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;        
    }
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i= 1; i < nums.length; i++) {
            if(nums[i] != nums[j]) {
                swap(nums, i, j+1);
                j++;
            }
        }
        return j+1;
    }
}