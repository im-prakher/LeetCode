class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        Arrays.fill(freq, 0);
        for(int road[] : roads) {
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Arrays.sort(freq);
        long sum = 0; int j = 1;
        for(int i : freq) {
            sum += (long)i * j;
            j++;
        }
        return sum;
    }
}