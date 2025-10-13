class Solution {
    public int maxArea(int[] nums) {
        int i = 0, j = nums.length - 1, area = 0;
        while(i < j) {
            int height = Math.min(nums[i], nums[j]);
            area = Math.max(area, height * (j-i));
            while(i < j && nums[i] <= height) i++;
            while(j > i && nums[j] <= height) j--;
        }
        return area;
    }
}