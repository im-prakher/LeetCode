class Solution {
    int MOD = 1000_000_007;
    long pow(long x, long n) {
        if(n == 0 || x == 1)
            return 1;
        if(n == 1)
            return x;
        long power = pow(x, n / 2);
        if(n % 2 == 0)
            return (power * power) % MOD;
        return (power * power * x) % MOD;
    }
    public int countGoodNumbers(long n) {
        long ans = (pow(5, (n+1)/2) * pow(4, n / 2)) % MOD;
        return (int)ans;
    }
}