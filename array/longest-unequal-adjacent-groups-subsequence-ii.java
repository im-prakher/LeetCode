class Solution {
    public boolean isHammingDiff(int i, int j, String[] words) {
        if(words[i].length() != words[j].length())
            return false;
        int diff = 1;
        for(int k = 0; k < words[i].length(); k++) {
            if(words[i].charAt(k) != words[j].charAt(k)) {
                if(diff == 0)
                    return false;
                diff--;
            }
        }
        return true;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(groups[i] != groups[j] && isHammingDiff(i, j, words)) {
                    if(dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }
        }
        int ans = 0, idx = -1;
        for(int i = 0; i < n; i++) {
            if(dp[i] > ans) {
                ans = dp[i];
                idx = i;
            }
        }

        List<String> res = new ArrayList<>();
        while(hash[idx] != -1) {
            res.add(words[idx]);
            idx = hash[idx];
        }
        res.add(words[idx]);
        Collections.reverse(res);
        return res;
    }
}