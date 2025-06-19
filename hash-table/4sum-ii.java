class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums3) {
            for(int j : nums4) 
                set.add(i+j);
        }
        int cnt = 0;
        for(int i : nums1) {
            for(int j : nums2) {
                if(set.contains(-i-j))
                    cnt++;
            }
        }
        return cnt;
    }
}