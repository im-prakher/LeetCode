class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int max = 0; long sum = 0;
        for(int i : damage) {
            max = Math.max(max, i);
            sum += i;
        }
        return sum - Math.min(max, armor) + 1;
    }
}