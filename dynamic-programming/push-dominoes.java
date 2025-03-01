class Solution {
    public String pushDominoes(String dom) {
        int n = dom.length();
        int[] infl = new int[n];
        int idx = -1;
        for(int i = n-1; i >= 0; i--) {
            char ch = dom.charAt(i);
            if(ch == '.') {
                if(idx == -1)
                    infl[i] = 0;
                else
                    infl[i] = i - idx;
            } else if(ch == 'L') {
                idx = i;
                infl[i] = -1;
            }
            else if(ch == 'R') {
                idx = -1;
                infl[i] = 1;
            }
        }
        idx = -1;
        for(int i = 0; i < n; i++) {
            char ch = dom.charAt(i);
            if(ch == '.') {
                if(idx == -1)
                    continue;
                if(Math.abs(infl[i]) == i - idx)
                    infl[i] = 0;
                else if(Math.abs(infl[i]) > i - idx || infl[i] == 0)
                    infl[i] = i - idx;
            } else if(ch == 'L')
                idx = -1;
            else if(ch == 'R')
                idx = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = infl[i] == -1 ? 'L' : infl[i] == 1 ? 'R' : '.';
            sb.append(ch);
        }
        return sb.toString();
    }
}