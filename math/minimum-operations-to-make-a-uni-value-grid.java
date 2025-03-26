class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = 0;
        int nums[] = new int[grid.length * grid[0].length];
       for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[0].length; j++) {
            nums[n++] = grid[i][j];
        }
       }
       Arrays.sort(nums);
       int mid = n/2, ops = 0;
       for(int i = 0; i < n; i++) {
            if( i == mid)
                continue;
            if((nums[mid] - nums[i]) % x != 0)
                return -1;
            else 
                ops += Math.abs((nums[mid] - nums[i])) / x;
       }
       return ops;
    }
}