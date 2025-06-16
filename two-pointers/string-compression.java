class Solution {
    public int compress(char[] str) {
        int cnt = 0, len = 0, prv = 0, idx = 0;
        for (int i = 0; i <= str.length; i++) {
            if (i != str.length && str[prv] == str[i])
                cnt++;
            else {
                str[idx++] = str[prv];
                if (cnt > 1) {
                    int num = cnt;
                    // determine length
                    while(num > 0) {
                        num /= 10;
                        idx++;
                    }
                    int k = idx;
                    while (cnt > 0) {
                        str[--k] = (char) ('0' + cnt % 10);
                        cnt /= 10;
                    }
                }
                prv = i;
                cnt = 1;
            }
        }
        return idx;
    }
}