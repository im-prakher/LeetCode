class Solution {
    public int sum(int n) {
        int res = 0;
        while(n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public int addDigits(int num) {
        int n = num;
        while(n / 10 > 0) {
            n = sum(n);
        }
        return n;
    }
}