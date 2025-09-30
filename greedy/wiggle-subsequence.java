class Solution {
    boolean signMatch(List<Integer> seq, int num) {
        if(seq.size() == 0)
            return true;
        else if(seq.size() == 1)    
            return seq.getLast() != num;
        int val1 = seq.getLast()  - seq.get(seq.size()- 2);
        int val2 = num - seq.getLast();
        return (val1 > 0 && val2 < 0) || (val1 < 0 && val2 > 0);
    }
    int func(int[] nums, int idx, List<Integer> seq) {
        if(idx == nums.length)
            return 0;
        int pick = 0;
        if(signMatch(seq, nums[idx])) {
            seq.add(nums[idx]);
            pick = 1 + func(nums, idx + 1, seq);
            seq.remove(seq.size()-1);
        }
        int not_pick = func(nums, idx+1, seq);
        return Math.max(pick, not_pick);
    }

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1)
            return 1;
        if(nums.length == 2)
            return nums[0] != nums[1] ? 2 : 1;
        return func(nums, 0, new ArrayList<Integer>());
    }
}