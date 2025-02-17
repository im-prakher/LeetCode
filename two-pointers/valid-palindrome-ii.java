class Solution {
    public boolean validPalindrome(String s) {
        int cnt = 0, n = s.length();
        char[] str = s.toCharArray();
        for(int i = 0; i < n/2; i++) {
            if(str[n-i-1] != str[i]) {            
                int j = i+1, k = i;
                boolean lf = false, rf = false;
                while(j <= n/2) {
                    if(str[j] != str[n-j]) {
                        lf = false;
                        break;
                    }
                    lf = true;
                    j++;
                }
                while(k <= n/2) {
                    if(str[k] != str[n-k-2]) {
                        rf = false;
                        break;
                    }
                    rf = true;
                    k++;
                }
                if(lf || rf)
                    return true;
                else 
                    return false;
            }                
        }
        return true;
    }
}