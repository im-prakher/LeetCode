class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                int freq= mp.getOrDefault(prod, 0);
                pairs += freq;
                mp.put(prod, freq + 1);
            }
        }
        return pairs * 8;
    }
}