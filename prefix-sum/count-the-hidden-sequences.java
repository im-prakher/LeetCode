class Solution {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        int min = diff[0], max = diff[0], sum = 0;
        for(int i = 0; i < diff.length; i++) {
            sum += diff[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        return Math.max(0, (upper - max) - (lower - min) + 1);
    }
}