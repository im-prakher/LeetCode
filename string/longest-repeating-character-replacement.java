class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[260];
        char str[] = s.toCharArray();
        int maxFreq = 0, res = 0;
        for(int i = 0, j = -1; i < str.length; i++) {
            maxFreq = Math.max(maxFreq, ++freq[str[i]]);
            while(i - j - maxFreq > k) {
                freq[str[++j]]--;
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
}