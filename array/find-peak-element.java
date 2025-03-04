class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length-1, peak = 0;
        while(lo <= hi) {
            int mid = (lo + hi) >> 1;
            if(mid!=nums.length-1 && nums[mid] > nums[mid+1]) {
                peak = mid;
                hi = mid-1;
            }
            else
                lo = mid + 1;
        }
        return peak;
    }
}