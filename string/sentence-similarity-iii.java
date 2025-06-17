class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length > sentence2.length) {
            s1 = sentence1.toCharArray();
            s2 = sentence2.toCharArray();
        } else {
            s2 = sentence1.toCharArray();
            s1 = sentence2.toCharArray();
        }
         = sentence1.toCharArray();
        char[] s2 = sentence2.toCharArray();
        int i = 0, j = 0, n = s1.length, m = s2.length;
        boolean gap = false;
        while(i < n && j < m) {
        }
    }
}