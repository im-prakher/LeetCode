class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length-1, peak = 0;
        while(lo <= hi) {
            int mid = (lo + hi) >> 1;
            if(lo == hi)
                return lo;
            if(nums[mid] > nums[mid+1]) {
                hi = mid;
            }
            else
                lo = mid + 1;
        }
        return peak;
    }
}