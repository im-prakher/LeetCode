class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        while(k-- > 0){
            sum += reward1[--n];
        }
        return sum;
    }
}