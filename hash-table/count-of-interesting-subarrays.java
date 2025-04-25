class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        long ans = 0, cnt = 0;
        Map<Integer, Long> mp = new HashMap<>();
        mp.put(0, 1l);
        for(int i : nums) {
            if(i % mod == k)
                cnt++;
            int rem = (int) (cnt % mod);
            int need = (rem - k + mod) % mod;
            if(mp.containsKey(need))
                ans += mp.get(need);
            mp.put(rem, mp.getOrDefault(rem, 0l)+ 1);
        }
        return ans;
    }
}