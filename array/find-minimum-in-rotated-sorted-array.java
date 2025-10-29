class Solution {
    public int findMin(int[] nums) {
        int i= 0, j= nums.length -1;
        if(nums[i] <= nums[j])
            return nums[i];
        while(i < j) {
            int mid = i + (j-i) / 2;
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            else if(nums[0] < nums[mid])
                i = mid+1;
            else
                j = mid;
        }
        return nums[i];
    }
}