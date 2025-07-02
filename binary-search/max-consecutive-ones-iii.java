class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = 0, flip = 0;
        for(int i = 0, j = -1; i < nums.length; i++) {        
            if(nums[i] == 0)
                flip++;
            while(flip > k) {
                if(nums[++j] == 0)
                    flip--;
            }
            len = Math.max(len, i - j);
        }
        return len;
    }
}