class Solution {
    public int lengthOfLongestSubstring(String s) {
     if(s.length() == 0)
        return 0;
     char str[] = s.toCharArray();
     int idx[] = new int[256];
     Arrays.fill(idx, -1);
     int len = 1;
     for(int j= 0, i = 0; i < s.length(); i++) {
        int c = (int)str[i];
        if(idx[c] != -1)
            j = idx[c];
        len = Math.max(len, i-j);
        idx[c] = i;
     }
     return len;
    }
}