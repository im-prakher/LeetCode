class Solution {
    public boolean isPallindrome(int i, int j, char[] str) {
        while(i < j) {
            if(str[i] != str[j])
                return false;
            i++; j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = str.length-1;
        while(i < j) {
            if(str[i] != str[j])
                return isPallindrome(i+1, j, str) || isPallindrome(i, j-1, str);
            i++; j--;
        }
        return true;
    }
}