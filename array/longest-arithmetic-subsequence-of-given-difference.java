class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int nums[] = new int[100_00];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(arr[i], 1 + mp.getOrDefault(arr[i]-difference, 0));
        }
        int res = mp.values().stream().max(Integer::compare).get();
        return res;
    }
}