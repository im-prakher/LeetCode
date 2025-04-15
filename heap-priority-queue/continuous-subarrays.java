class Solution {
    public long continuousSubarrays(int[] nums) {
        long cnt = 0;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while(mp.lastKey() - mp.firstKey() > 2) {
                mp.put(nums[j], mp.get(nums[j]) - 1);
                if(mp.get(nums[j]) == 0)
                    mp.remove(nums[j]);
               j++;   
            }
            cnt += i - j + 1;
        }
        return cnt;
    }
}