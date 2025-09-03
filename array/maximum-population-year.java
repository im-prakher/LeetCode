class Solution {
    public int maximumPopulation(int[][] logs) {
        int year[] = new int[2052];
        for(int[] log : logs) {
            year[log[0]]++;
            year[log[1]]--;
        }
        int pop = 0, maxPop = 0, earlyYear = 1950;
        for(int i = 1950; i < 2052; i++) {
            pop += year[i];
            if(pop > maxPop) {
                earlyYear = i;
                maxPop = pop;
            }
        }
        return earlyYear;
    }
}