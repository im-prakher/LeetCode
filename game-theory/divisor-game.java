class Solution {
    public boolean divisorGame(int n) {
        int i = n / 2, j = 0;
        while(i > 0) {
            if(n % i == 0) {
                n = n - i;
                i = n / 2;
                j++;
                continue;
            }
            i--;
        }
        return j % 2 != 0;
    }
}