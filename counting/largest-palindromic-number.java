class Solution {
    public String largestPalindromic(String num) {
        int n = num.length();
        int freq[] = new int[10];
        for(char ch : num.toCharArray()) {
            freq[ch-'0']++;
        }
        if(freq[0] == num.length())
            return "0";
        StringBuilder sb = new StringBuilder();
        int idx = 0, j = -1;
        for(int i =9 ; i >= 0; i--) {
            int cnt = freq[i] - (freq[i] % 2), c = cnt;
            freq[i] = freq[i] % 2;              
            boolean isZero = i!=0 || sb.length() > 0;
            while(cnt-- > 0 && isZero) {
                sb.insert(idx, (char)('0' + i));
            }
            idx += isZero ? (c / 2) : idx;
            j = (j==-1 && freq[i] == 1) ? i : j;
        }
        if(j!=-1)
            sb.insert(idx, (char)('0'+j));
        return sb.toString();
    }
}