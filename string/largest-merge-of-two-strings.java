class Solution {
    int next(char[] str, int k) {
        int i = k + 1;
        while (i < str.length && str[i] == str[k]) {
            i++;
        }
        return i;
    }

    int fill(char[] str, char[] s1, int k, int a, int i) {
        while (i < s1.length && i <= a)
            str[k++] = s1[i++];
        return k;
    }

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
                    a = next(s1, a);
                    b = next(s2, b);
                }
                a = a == n ? i : a;
                b = b == m ? j : b;
                if (s1[a] > s2[b]) {
                    k = fill(str, s1, k, a, i);
                    i = a + 1;
                } else {
                    k = fill(str, s2, k, b, j);
                    j = b + 1;
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