class Solution {
    public int maxScore(int[] cardPoints, int k) {
        k = cardPoints.length-k;
        int sum = 0, minSum = (int) 1e9, total = 0;
        for(int i = 0; i < cardPoints.length; i++) {
            sum += i<k ? cardPoints[i] : cardPoints[i] - cardPoints[i-k]; 
            total += cardPoints[i];
            if(i >= k-1)
                minSum = Math.min(minSum, sum);
        }
        return total - minSum;
    }
}