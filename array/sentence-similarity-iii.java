class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1, s2;
        if(sentence1.length() > sentence2.length()) {
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        } else {
            s2 = sentence1.split(" ");
            s1 = sentence2.split(" ");
        }
        int i = 0, j = 0, n = s1.length, m = s2.length;
        boolean missing = false, left = true, right = true;
        while(i < n && j < m) {
            if(s1[i].equals(s2[j])) {
                i++;
                j++;
            } else if(missing) {
                left = false;
            } else {
                while(++i < n && !s1[i].equals(s2[j]));
                missing = true;
            }
        }
        if(missing && (i < n || j < m))
            left = false;
        int a = n-1, b = m-1;
        missing = false;
        while(a >= 0 && b >= 0) {
            if(s1[a].equals(s2[b])) {
                a--;
                b--;
            } else if(missing) {
                right = false;
            } else {
                while(--a >= 0 && !s1[a].equals(s2[b]));
                missing = true;
            }
        }
        if(missing && (a >= 0 || b >= 0))
            right = false;
        return left || right;
    }
}