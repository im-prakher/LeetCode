class Solution {
    public boolean canJump(int[] nums) {
        int jmp = 0, idx = 0, n = nums.length;
        for(int i : nums) {
            jmp = Math.max(jmp, i);
            if(jmp + idx >= n-1)
                return true;
            if(jmp == 0)
                return false;
            jmp--;
            idx++;
        }
        return false;
    }
}