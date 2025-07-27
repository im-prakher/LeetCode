class Solution {
    public int jump(int[] nums) {
          int jmp = nums[0], idx = 0, n = nums.length, hops = 1;
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