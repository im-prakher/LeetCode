class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            mp.put(nums[i], i);
        }
        for(int[] ops : operations) {
            int idx = mp.get(ops[0]);
            nums[idx] = ops[1];
            mp.remove(ops[0]);
            mp.put(ops[1], idx);
        }
        return nums;
    }
}