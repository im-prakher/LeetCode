class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zero = 0, ones = 0, len = 0;
        for(int i = 0; i < nums.length; i++) {
            zero += nums[i] == 0 ? 1 : 0;
            ones += nums[i] == 1 ? 1 : 0;
            if(zero <= 1)
                len = Math.max(len, zero + ones);
            else {
                zero = 1; ones = 0;
            }           
       }
       return len;
    }
}