class Solution {
    public boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int count(String word) {
        if(vowel(word.charAt(0)) && vowel(word.charAt(word.length()-1)))
            return 1;
        return 0;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prf = new int[n+1];
        prf[0] = 0;
        for(int i = 1; i <= n; i++) {
            prf[i] = count(words[i-1]) + prf[i-1];
        }
        int[] ans = new int[queries.length];
        int k = 0;
        for(int[] qry : queries) {
            ans[k++] = prf[qry[1]+1] - prf[qry[0]];
        }
        return ans;
    }
}