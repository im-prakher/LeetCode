class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] str = new char[word1.length() + word2.length()];
        int i = 0, j = 0, k = 0;
        while(i < word1.length() && j < word2.length()) {
            if(k % 2 == 0)
                str[k++] = word1.charAt(i++); 
            else 
                str[k++] = word2.charAt(j++);                 
        }
        while(i < word1.length()) {
            str[k++] = word1.charAt(i++);
        }
        while(j < word2.length()) {
            str[k++] = word2.charAt(j++);
        }
        return new String(str);
    }
}