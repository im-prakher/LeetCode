class Solution {
    public boolean isPredecessor(String s1, String s2) {
        int match = 0;
        int i = 0, j = 0;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        while(i < a.length && j < b.length) {
            if(a[i] == b[j])
                match++;
            else 
                j--;
            i++; j++;
        }
        return match == a.length - 1;
    }

    public int solve(String[] words, int idx, int prev, int dp[][]) {
         if(idx == words.length)
            return 0;
        if(dp[idx][prev+1] !=-1)
            return dp[idx][prev+1];
        int pick = 0;
        int no_pick = solve(words, idx+1, prev, dp);
        if(prev == -1 || isPredecessor(words[idx], words[prev])) 
            pick = 1 + solve(words, idx+1, idx, dp);
        return dp[idx][prev+1] = Math.max(pick, no_pick);
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.sort(words, (a, b)->{
            return a.length() == b.length() ? a.compareTo(b) 
            : Integer.compare(a.length(),b.length());
        });
        // return solve(words, 0, -1, dp);
        // int dp[][] = new int[n+1][n+1];
        int res = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(words[i].length() - words[j].length() == 1 
                    && isPredecessor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;  
    }
}