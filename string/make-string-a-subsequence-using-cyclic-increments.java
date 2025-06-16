class Solution {
    boolean incMatch(char a, char b) {
        if(a == 'z')
            a = 'a';
        else
            a = (char)(a+1);
        return a == b;
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        int i = 0, j = 0, n = s1.length, m = s2.length;
        if(m > n)
            return false;
        while(i < n && j < m) {
            if(s1[i] == s2[j] || incMatch(s1[i], s2[j]))
                j++;
            i++;
        }
        return j == m;
    }
}