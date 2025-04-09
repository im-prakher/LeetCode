class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] < k)
            return -1;
        int cnt = nums[0] == k ? 0 : 1;
        for(int i= 0; i < nums.length-1; i++ ){
            // if(nums[i] == k)
            //     continue;
            if(nums[i] != nums[i+1])
                cnt++;
        }
        return cnt;
    }
}