class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                mp.putIfAbsent(prod, -1);
                mp.put(prod, mp.get(prod) + 1);
            }
        }
        int cnt = 0;
        for(int k : mp.keySet()) {
            cnt += mp.get(k);
        }
        return cnt * 8;
    }
}