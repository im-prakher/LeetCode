class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, cnt = 0;
        for(int i : nums) {
            sum += i;
            if(mp.containsKey((sum % k + k) % k))
                cnt += mp.get((sum % k + k) % k);
            if(sum % k == 0)
                cnt++;
            mp.put((sum % k + k) % k, mp.getOrDefault((sum % k + k) % k, 0) + 1);
        }
        return cnt;
    }
}