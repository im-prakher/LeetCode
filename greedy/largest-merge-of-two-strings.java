class Solution {
    public String largestMerge(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        int i = 0, n = s1.length, j = 0, m = s2.length, k = 0;
        char[] str = new char[m + n];
        while (i < n && j < m) {
            if (s1[i] > s2[j])
                str[k++] = s1[i++];
            else if (s1[i] < s2[j])
                str[k++] = s2[j++];
            else {
                int a = i, b = j;
                while (a < n && b < m && s1[a] == s2[b]) {
                    a++;
                    b++;
                }
                if (a < n && b < m && s1[a] > s2[b]) {
                    str[k++] = s1[i++];
                } else if (b < m) {
                    str[k++] = s2[j++];
                } else {
                    str[k++] = s1[i++];
                }
            }
        }
        while (i < n)
            str[k++] = s1[i++];

        while (j < m)
            str[k++] = s2[j++];
        return new String(str);
    }
}