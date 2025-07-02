class Solution {
    public int numberOfSubstrings(String s) {
        char str[] = s.toCharArray();
        int a = 0, b = 0, c = 0, cnt = 0;
        for(int i = 0, j = 0; i < str.length; i++) {
            a += str[i] == 'a' ? 1 : 0;
            b += str[i] == 'b' ? 1 : 0;
            c += str[i] == 'c' ? 1 : 0;
            while(a > 0 && b > 0 && c > 0) {
                a -= str[j] == 'a' ? 1 : 0;
                b -= str[j] == 'b' ? 1 : 0;
                c -= str[j] == 'c' ? 1 : 0;
                j++;
            }
            cnt += j;
        }
        return cnt;
    }
}