class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length(), max = 0;
        int str[] = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            str[i] = pattern.charAt(i) == 'D' ? str[i+1] + 1 : 0;
        }
        for(int i = 0; i <= n; ) {
            if(str[i] == 0) 
                str[i++] = ++max;
            else {
                int dcnt = str[i];
                int val = max + str[i] + 1, cpy = val;
                while(i <= n && val > max) {
                    str[i++] = val--;
                }
                max = cpy;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i : str)
            res.append(String.valueOf(i));
        return res.toString();
    }
}