class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(arr[i], 1 + mp.getOrDefault(arr[i]-difference, 0));
            ans = Math.max(ans, mp.get(arr[i]));
        }
        return ans;
    }
}