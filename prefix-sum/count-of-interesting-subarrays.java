class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        long ans = 0, cnt = 0;
        Map<Long, Integer> mp = new HashMap<>();
        for(int i : nums) {
            if(i % mod == k)
                cnt++;
            if(mp.containsKey(cnt % mod))
                ans += mp.get(cnt % mod);
            mp.put(cnt % mod, + 1);
        }
        if(mp.containsKey(cnt % mod))
            ans++;
        return ans;
    }
}