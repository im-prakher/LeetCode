class Solution {
    public int minimumOperations(int[] nums) {
        int[] lastIdx = new int[102];
        int ops = 0;
        for(int i= nums.length-1; i >= 0; i--) {
            if(lastIdx[nums[i]]!=0) {
                ops = i / 3 + 1;
                break;
            }
            lastIdx[nums[i]] = i;
        }
        return ops;
    }
}