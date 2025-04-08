class Solution {
    public int minimumOperations(int[] nums) {
        int[] lastIdx = new int[102];
        int ops = 0;
        for(int i= nums.length-1; i >= 0; i--) {
            if(lastIdx[nums[i]]!=0) {
                ops += (i+1) / 3 + ((i+1) % 3 != 0 ? 1 : 0);
                break;
            }
            lastIdx[nums[i]] = i;
        }
        return ops;
    }
}