class Solution {
    long max;
    Map<String, Long> memo = new HashMap<>();
    void insert(long sum, int[] ans, Map<Long, int[]> mp) {
        boolean flag = true;
        if(mp.containsKey(sum)) {
            for(int i = 0; i < 3; i++) 
                flag = mp.get(sum)[i] < ans[i] ? false : flag;
        }
        if(flag) {
            int[] nums = ans.clone();
            mp.put(sum, nums);
        }
    }
    public long triplets(List<Integer> list, int c, int k, int[] ans, int i, long sum, Map<Long, int[]> mp) {
        if(c == 3) {
            if(sum > max) {
                insert(sum, ans, mp);
                max = sum;
            }
            return max;
        }
        if(i >= list.size())
            return Integer.MIN_VALUE;
        String key = c + "|" + i + "|" + sum;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        ans[c] = i;
        long pick = triplets(list, c+1, k, ans, i+k, sum + list.get(i), mp);
        ans[c] = list.size();
        long not_pick = triplets(list,c, k, ans, i+1, sum, mp);
        long res = Math.max(pick, not_pick);
        memo.put(key, res);
        return res;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        max = Long.MIN_VALUE;
        Map<Long, int[]> mp = new HashMap<>();
        int sum =0 ;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum -= (i >= k) ? nums[i-k] : 0;
            if(i >= k-1) 
                list.add(sum);
        }
        int[] ans = new int[3];
        Arrays.fill(ans, list.size());
        long val = triplets(list, 0, k, ans, 0, 0, mp);
        return mp.get(val);
    }
}