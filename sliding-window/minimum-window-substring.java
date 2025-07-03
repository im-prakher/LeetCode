class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0, m = mp.size(), n = s.length(), res = n+1, a = -1, b = -1;
        int[] freq = new int[128];
        char str[] = s.toCharArray();
        for(int i = 0, j = 0; i < n; i++) {
            cnt += mp.getOrDefault(str[i], n*2) == ++freq[str[i]] ? 1 : 0;
            while(cnt == m) {
                if(res > i-j+1) {
                    a = j; b = i;
                    res = i-j+1;
                }
                if(mp.containsKey(str[j])) {
                    if(freq[str[j]] == mp.get(str[j]))
                        cnt--;
                }
                freq[str[j++]]--;
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