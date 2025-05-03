class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length -1;
        if(nums[0] <= nums[j])
            return nums[0];
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(mid != nums.length-1 && nums[mid] > nums[mid + 1])
                return nums[mid+1];
            else if(nums[i] <= nums[mid])
                i = mid + 1;
            else 
                j = mid - 1;
        }
        return nums[j];
    }
}