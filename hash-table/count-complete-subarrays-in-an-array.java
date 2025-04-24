class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length, cnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) 
            set.add(i);
        int distinct = set.size();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0, j = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while(mp.size() == distinct) {
                cnt += n-i;
                remove(mp, nums[j]);
                j++;
            }
        }
        return cnt;
    }

    public void remove(Map<Integer, Integer> mp, int x) {
        int cnt = mp.get(x);
        if( cnt > 1)
            mp.put(x, cnt-1);
        else
            mp.remove(x);
    }
}