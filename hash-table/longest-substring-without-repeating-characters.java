class Solution {
    public int lengthOfLongestSubstring(String s) {
     if(s.length() == 0)
        return 0;
     char str[] = s.toCharArray();
     int idx[] = new int[256];
     Arrays.fill(idx, -1);
     int len = 1;
     for(int i = 0, j = 0; i < s.length(); i++) {
        int c = str[i] - 'a';
        if(idx[c] != -1)
            j = i;
        len = Math.max(len, i-j+1);
        idx[c] = i;
     }
     return len;
    }
}