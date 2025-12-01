class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(nums[i] == 0) {
                if(sum != 0)
                    list.add(sum);
                list.add(0);
                sum = 0;
            }
        }
        list.add(sum);
        int ans = list.get(0), m = list.size();
        for(int i = 0; i < m; i++) {
            int lft = i > 0 ? list.get(i-1) : 0;
            int rht = i < m-1 ? list.get(i+1) : 0;
            if(list.get(i) == 0) {
                ans = Math.max(ans, lft + rht);
            }
        }
        return  list.size() == 1 ? ans - 1 : ans;
    }
}