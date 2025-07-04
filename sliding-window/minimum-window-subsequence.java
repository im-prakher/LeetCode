class Solution {
    public String minWindow(String s1, String s2) {
        char pat[] = s2.toCharArray();
        char str[] = s1.toCharArray();
        int cnt = 0, k = pat.length, res = str.length+1, a = -1, b = -1;
        int[] freq = new int[128];
        for(int i = 0, j = 0, p = 0; i < str.length; i++) {
            if(p!=0 && pat[p-1] == str[i])
                freq[str[i]]++;
            if(str[i] == pat[p])
                cnt += freq[pat[p++]]++ == 0 ? 1 : 0;
            if(cnt >= k)
                p = 0;
            while(cnt >= k) {
                if(res > i-j+1) {
                    a = j; b = i;
                    res = i-j+1;
                }
                if(pat[p] == str[j] && --freq[str[j]] == 0) {
                        cnt--;
                        p++;
                }
                j++;
                if(cnt < k) {
                    p = 0;
                    cnt = 0;
                    freq = new int[128];
                }
            }
        }
        if(a == -1)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = a; i <= b; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}