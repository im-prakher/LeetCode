class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        long sum = 0; int len = 0;
        Map<Long, Integer> mp = new HashMap<>();
        for(int i= 0; i < nums.length; i++) {
            sum += nums[i];
            mp.putIfAbsent(sum, i);
            if(sum == k)
                len = Math.max(len, i+1);
            if(mp.containsKey(sum-k)) 
                len = Math.max(len, i - mp.get(sum-k));
        }
        return len;
    }
}