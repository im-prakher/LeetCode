class Solution {
    public int lengthOfLongestSubstring(String s) {
     if(s.length() == 0)
        return 0;
     char str[] = s.toCharArray();
     int idx[] = new int[256];
     Arrays.fill(idx, -1);
     int len = 1;
     for(int i = 0, j = 0; i < str.length; i++) {        
        j = idx[str[i]] > j ? idx[str[i]] : j;
        len = Math.max(len, i-j);
        idx[str[i]] = i;
    }
     return len;
    }
}