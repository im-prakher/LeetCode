class Solution {
    boolean signMatch(List<Integer> seq, int num) {
        int val1 = seq.get(seq.size()-1) - seq.get(seq.size()- 2);
        int val2 = num - seq.get(seq.size()- 1);
        return (val1 > 0 && val2 < 0) || (val1 < 0 && val2 > 0);
    }
    int func(int[] nums, int idx, List<Integer> seq) {
        if(idx == nums.length)
            return 0;
        int pick = 0;
        if(seq.size() <  2 || signMatch(seq, nums[idx])) {
            seq.add(nums[idx]);
            pick = 1 + func(nums, idx + 1, seq);
            seq.remove(seq.size()-1);
        }
        int not_pick = func(nums, idx+1, seq);
        return Math.max(pick, not_pick);
    }

    public int wiggleMaxLength(int[] nums) {
        return func(nums, 0, new ArrayList<Integer>());
    }
}