class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        char str[] = s.toCharArray();
        for(char ch : str)
            set.add(ch);
        int ans = 0, n = str.length;
        for(var ch : set) {
            int cnt = 0;
            for(int i = 0, j = 0; i < n; ) {
                if(str[i] == ch) 
                    i++;
                else if(cnt < k) {
                    cnt++; i++;
                } else {
                    while(j < n && ch==str[j++]) 
                    cnt--;
                }
                ans = Math.max(ans, i - j);
            }
        }
        return ans;
    }
}