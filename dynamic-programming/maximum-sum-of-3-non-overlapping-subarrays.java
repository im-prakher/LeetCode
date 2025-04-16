class Solution {
    
    int max;
    void insert(int sum, int[] ans, Map<Integer, int[]> mp) {
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
    public int triplets(List<Integer> list, int[] nums, int c, int k, int[] ans, int i, int sum, Map<Integer, int[]> mp) {
        if(c == 0) {
            if(sum >= max) {
                insert(sum, ans, mp);
                max = sum;
            }
            return max;
        }
        if(i < 0)
            return Integer.MIN_VALUE;
        ans[c-1] = i;
        int pick = triplets(list, nums, c-1, k, ans, i-k, sum + list.get(i), mp);
        ans[c-1] = nums.length;
        int not_pick = triplets(list, nums, c, k, ans, i-1,  sum, mp);
        return Math.max(pick, not_pick);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        max = Integer.MIN_VALUE;
        Map<Integer, int[]> mp = new HashMap<>();
        int sum =0 ;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum -= (i >= k) ? nums[i-k] : 0;
            if(i >= k-1) 
                list.add(sum);
        }
        int[] ans = new int[3];
        Arrays.fill(ans, list.size());
        int val = triplets(list, nums, 3, k, ans, list.size() - 1, 0, mp);
        return mp.get(val);
    }
}