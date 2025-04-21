class Solution {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        int min = 0, max = 0, sum = 0;
        for(int i = 0; i < diff.length; i++) {
            sum += diff[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            if(max - min > upper-lower)
                return 0;
        }
        return (upper - max) - (lower - min) + 1;
    }
}