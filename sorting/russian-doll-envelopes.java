class Solution {
    public int lower_bound2d(List<int[]> nums, int[] target) {
        int i = 0, j = nums.size()-1;
        while(i <= j) {
            int mid = (i + j) >> 1;
            if(nums.get(mid)[1] < target[1])
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    public int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums, (a, b)-> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        List<int[]> bin = new ArrayList<>(); // will always be in increasing order
        bin.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int[] last = bin.getLast();
            if(last[1] < nums[i][1])
                bin.add(nums[i]);
            else {
                int lb = lower_bound2d(bin, nums[i]);
                bin.set(lb, nums[i]);
            }
        }
        return bin.size();
    }
}