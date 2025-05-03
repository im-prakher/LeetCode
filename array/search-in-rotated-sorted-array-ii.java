class Solution {
    public boolean search(int[] nums, int target) {
     int i = 0, j = nums.length -1 ;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[i] <= nums[mid]) { 
                while(nums[i] == nums[mid])
                    i++;
                if(nums[i] <= target && target < nums[mid])
                    j = mid - 1;
                else 
                    i = mid + 1;
            } else {
                while(nums[j] == nums[mid])
                    j--;
                if(nums[mid] < target && target <= nums[j])
                    i = mid + 1;
                else
                    j = mid - 1;
            }
        }
        return false;   
    }
}