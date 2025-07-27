class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int jmp = 0, idx = 0, n = nums.length, hops = 0;
        for(int i : nums) {
            if(jmp < i) {
                hops++;
                jmp = i;
            }
            if(jmp + idx >= n-1)
                break;
            jmp--;
            idx++;
        }
        return hops;
    }
}