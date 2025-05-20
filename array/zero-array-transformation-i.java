class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int sum = 0;
        for(int i : nums)  {
            sum += i;
        }
        int transform = 0;
        for(int[] query : queries) {
            transform += query[1] - query[0] + 1;
        }
        return sum <= transform; 
    }
}