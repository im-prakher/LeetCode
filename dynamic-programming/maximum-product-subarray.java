class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], currMax = nums[0], currMin = nums[0], curr = nums[0];
        for(int i = 1; i < nums.length; i++){
            curr = nums[i];
            int tmpMax = Math.max(curr, Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(curr, Math.min(currMin * nums[i], currMax* nums[i]));
            currMax = tmpMax;
            max = Math.max(max, currMax);
        } 
        return max;
    }
}