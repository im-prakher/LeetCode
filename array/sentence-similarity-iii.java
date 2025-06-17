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
        boolean missing = false;
        while(i < n && j < m) {
            if(s1[i].equals(s2[j])) {
                i++;
                j++;
            } else if(missing) {
                return false;
            } else {
                while(++i < n && !s1[i].equals(s2[j]));
                missing = true;
            }
        }
        if(missing && (i < n || j < m))
            return false;
        return true;
    }
}