class Solution {
    public boolean canJump(int[] nums) {
        int jmp = 0, idx = 0;
        for(int i : nums) {
            jmp = Math.max(jmp, i);
            if(jmp + idx >= nums.length-1)
                return true;
            else if(jmp == 0)
                return false;
            jmp--;
            idx++;
        }
        return false;
    }
}