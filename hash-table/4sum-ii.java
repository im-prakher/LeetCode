class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : nums3) {
            for(int j : nums4) 
                mp.put(i+j, mp.getOrDefault(i+j, 0) + 1);
        }
        int cnt = 0;
        for(int i : nums1) {
            for(int j : nums2) {
                if(mp.containsKey(-i-j))
                    cnt += mp.get(-i-j);
            }
        }
        return cnt;
    }
}