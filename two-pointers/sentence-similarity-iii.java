class Solution {
    public String[] reverse(String[] str) {
        int i = 0, j = str.length - 1;
        while (i < j) {
            String tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        return str;
    }

    // checks if there's only one missing sentence that can be inserted
    // else returns false if more or words mismatch
    public boolean similar(String[] s1, String[] s2) {
        int i = 0, j = 0, n = s1.length, m = s2.length;
        boolean missing = false;
        while (i < n && j < m) {
            if (s1[i].equals(s2[j])) {
                i++;
                j++;
            } else if (missing) {
                return false;
            } else {
                while (++i < n && !s1[i].equals(s2[j]))
                    ;
                missing = true;
            }
        }
        // check if end words are matching, then increment
        while (i > 0 && i < n && s1[i].equals(s1[i - 1]))
            i++;
        // If one sentence is mising, and 
        // again there's a missing sentence or word mismatch ahead
        if (missing && (i < n || j < m))
            return false;
        return true;
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1, s2;
        if (sentence1.length() > sentence2.length()) {
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        } else {
            s2 = sentence1.split(" ");
            s1 = sentence2.split(" ");
        }
        // check from left to right and right to left
        // edge cases: "A", "a A b A", 
        // will be good when matched from right to left
        return similar(s1, s2) || similar(reverse(s1), reverse(s2));
    }
}