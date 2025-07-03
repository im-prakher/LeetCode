class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int[] tmap = new int[128];
        int cnt = 0, dist = 0, n = s.length(), res = n+1, a = -1, b = -1;
        for(char ch : t.toCharArray()) {
            if(tmap[ch] == 0)
                dist++;
            tmap[ch]++;
        }
        char str[] = s.toCharArray();
        for(int i = 0, j = 0; i < n; i++) {
            cnt += tmap[str[i]] == ++freq[str[i]] ? 1 : 0;
            while(cnt == dist) {
                if(res > i-j+1) {
                    a = j; b = i;
                    res = i-j+1;
                }
                if(freq[str[j]]-- == tmap[str[j++]])
                    cnt--;
            }
        }
        if(a == -1)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = a; i <= b; i++) 
            sb.append(str[i]);
        return sb.toString();
    }
}