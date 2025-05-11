class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i = -1, j = -1, k = 0, ans = Integer.MAX_VALUE;
        for(String word : wordsDict) {
            if(word1.equals(word))
                i = k;
            else if(word2.equals(word))
                j = k;
            if(i >= 0 && j >=0)
                ans = Math.min(ans, Math.abs(i-j));
            k++;
        }
        return ans;
    }
}