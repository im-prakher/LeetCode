class Solution {
    //get cnt of elements less than val
    public int lower_bound(int[] nums, int val) {
        int cnt = 0, i = 0, j = nums.length-1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum < val) {
                cnt += j-i;
                i++;
            } else
                j--;            
        }
        return cnt;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper+1) - lower_bound(nums, lower);
    }
}