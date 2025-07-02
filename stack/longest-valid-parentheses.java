class Solution {
    public int longestValidParentheses(String s) {
        int cnt = 0, top = -1, res = 0, len = 0;
        int stack[] = new int[100_000];
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '(') {
                stack[++top] = i;
            } else if(top != -1) {
                len += 2;
                top--;
            } else {
                res = Math.max(res, len);
                len = 0;
            }
        }
        return Math.max(res, len);
    }
}