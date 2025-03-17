class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length % 2 != 0)
            return false;
        int cnt = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1])
                cnt++;
            else if(cnt % 2 != 0) 
                return false;
            else 
                cnt = 1;
        }
        return cnt % 2 == 0;
    }
}