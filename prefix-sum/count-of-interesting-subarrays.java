class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        long ans = 0; int cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i : nums) {
            cnt += i % mod == k ? 1 : 0;
            int need = (cnt - k + mod) % mod;
            ans += mp.getOrDefault(need, 0);
            mp.put(cnt % mod, mp.getOrDefault(cnt % mod, 0)+ 1);
        }
        return ans;
    }
}