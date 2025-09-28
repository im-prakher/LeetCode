class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int val = 1 + mp.getOrDefault(arr[i]-difference, 0);
            mp.put(arr[i], val);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}