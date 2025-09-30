class Solution {
    Map<String, Map<Integer, Integer>> dp;
    boolean signMatch(StringBuilder seq, int num) {
        int n = seq.length();
        if(n == 0)
            return true;
        else if(n <= 3) {
            String digit = "";
            for(int i = n - 1; seq.charAt(i) != '_'; i--) {
                digit = seq.charAt(i) + digit;
            }
            return Integer.valueOf(digit) != num;
        }
        int cnt = 2, i;
        String digit = "";
        for(i = n - 1; seq.charAt(i) != '_'; i--) {
            digit = seq.charAt(i) + digit;
        }
        int last = Integer.valueOf(digit);
        digit = "";
        for( i = i-1; seq.charAt(i) != '_'; i--) {
            digit = seq.charAt(i) + digit;
        }
        int secLast = Integer.valueOf(digit);
        int val1 = last  - secLast;
        int val2 = num - last;
        return (val1 > 0 && val2 < 0) || (val1 < 0 && val2 > 0);
    }
    int func(int[] nums, int idx, StringBuilder seq, Map<String, Map<Integer,Integer>> dp) {
        if(idx == nums.length)
            return 0;
        String str = seq.toString();
        if(dp.containsKey(str) && dp.get(str).containsKey(idx))
            return dp.get(str).get(idx);
        int pick = 0;
        if(signMatch(seq, nums[idx])) {
            seq.append("_");
            String digit = String.valueOf(nums[idx]);
            seq.append(digit);
            pick = 1 + func(nums, idx + 1, seq, dp);
            seq.delete(seq.length() - digit.length() - 1, seq.length());
        }
        int not_pick = func(nums, idx+1, seq, dp);
        int ans = Math.max(pick, not_pick);
        dp.putIfAbsent(seq.toString(), new HashMap<>());
        dp.get(seq.toString()).put(idx, ans);
        return ans;
    }

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1)
            return 1;
        if(nums.length == 2)
            return nums[0] != nums[1] ? 2 : 1;
        dp = new HashMap<>();
        return func(nums, 0, new StringBuilder(), dp);
    }
}