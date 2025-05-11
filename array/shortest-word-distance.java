class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i = -1, j = -1, k = 0;
        for(String word : wordsDict) {
            if(i!=-1 && j!=-1)
                break;
            if(word1.equals(word))
                i = k;
            else if(word2.equals(word))
                j = k;
            k++;
        }
        return Math.abs(i-j);
    }
}