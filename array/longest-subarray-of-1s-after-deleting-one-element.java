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
        int ans = list.get(0);
        for(int i = 1; i < list.size() - 1; i++) {
            if(list.get(i) == 0) {
                ans = Math.max(ans, list.get(i-1) + list.get(i+1));
            }
        }
        return  list.size() == 1 ? ans - 1 : ans;
    }
}