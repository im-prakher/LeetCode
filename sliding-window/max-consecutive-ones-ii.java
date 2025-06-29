class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zdx = -1, len = 0, zero = 0, j = -1;
        for(int i = 0; i < nums.length; i++) {
            zero += nums[i] == 0 ? 1 : 0;
            if(zero > 1) {
                j = zdx;
                zero = 1;
            }
            zdx = nums[i] == 0 ? i : zdx;
            len = Math.max(len, i-j);
        }
       return len;
    }
}