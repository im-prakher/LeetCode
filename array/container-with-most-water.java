class Solution {
    public int maxArea(int[] nums) {
        int i = 0, j = nums.length - 1, area = 0;
        while(i < j) {
            area = Math.max(area, Math.min(nums[i], nums[j]) * (j-i));
            if(nums[i] < nums[j]) {
                while(++i < j && nums[i] < nums[j]);
            }
            else {
                while(--j > i && nums[i] >= nums[j]);
            }
        }
        return area;
    }
}