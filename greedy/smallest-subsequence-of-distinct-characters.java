class Solution {
    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];
        int[] used = new int[26];
        char[] str = s.toCharArray();
        for(char ch : str) {
            cnt[ch-'a']++;
        }
        char[] stack = new char[str.length];
        int top = -1;
        for(int i = 0; i < str.length; i++) {
            cnt[str[i]-'a']--;
            if(used[str[i]-'a'] > 0)
                continue;
            while(top!=-1 && stack[top] > str[i] && cnt[stack[top]-'a'] > 0) {
                used[stack[top]-'a']--;
                top--;
            }
            stack[++top] = str[i];
            used[str[i]-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j <= top) {
            sb.append(stack[j++]);
        }
        return sb.toString();
    }
}