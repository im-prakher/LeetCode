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

    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.sort(words, (a, b)->{
            return a.length() == b.length() ? a.compareTo(b) 
            : Integer.compare(a.length(),b.length());
        });
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