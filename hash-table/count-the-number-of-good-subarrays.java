class Solution {
    public long countGood(int[] nums, int k) {
        long cnt = 0, pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            pairs += map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(pairs > k)
                cnt++;
        }
        int j = 0;
        while(pairs >= k) {
            cnt++;
            map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
            pairs -= map.get(nums[j]);
            if(map.get(nums[j]) == 0)
                map.remove(nums[j]);
            j++;
        }
        return cnt;
    }
}