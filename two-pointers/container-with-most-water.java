class Solution {
    public int maxArea(int[] nums) {
        int i = 0, j = nums.length - 1, area = 0;
        while(i < j) {
            int height = Math.min(nums[i], nums[j]);
            area = Math.max(area, height * (j-i));
            if(nums[i] < nums[j]) {
                while(++i < j && nums[i] <= height);
            }
            else {
                while(--j > i && nums[j] <= height);
            }
        }
        return area;
    }
}