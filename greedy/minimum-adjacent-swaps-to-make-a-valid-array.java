class Solution {
    public int minimumSwaps(int[] nums) {
        int min = 0, max = 0;
        for(int i= 0; i < nums.length; i++) {
            if(nums[min] > nums[i])
                min = i;
            if(min!=i && nums[max] <= nums[i])
                max = i;
        }
        int ans = nums.length -1 - max + min;
        return max < min ? ans -1 : ans;
    }
}