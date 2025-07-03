class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int cnt = 0, n = s.length(), len = 0;
        int freq[] = new int[260];
        char str[] = s.toCharArray();
        for(int i = 0, j = -1; i < n; i++) {
            cnt += freq[str[i]]++ == 0 ? 1 : 0;
            while(cnt > k) {
                cnt -= --freq[str[++j]] == 0 ? 1 : 0;
            }
            len = Math.max(len, i-j);
        }
        return len;
    }
}