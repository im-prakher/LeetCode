class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int nums[] = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = 1;
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] - arr[j] == difference)
                    max = Math.max(max, nums[j]);
            }
            nums[i] += max;
        }
        int res = Arrays.stream(nums).max().getAsInt();
        return res;
    }
}