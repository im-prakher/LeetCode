class Solution {
    public int getSum(int a, int b) {
      int carry, res = 0, k = 0;
      while(a > 0 || b > 0) {
        int p = a & 1, q = b & 1;
        a = a >> 1;
        b = b >> 1;
        carry = p & q;
        res += (p ^ q) * Math.pow(2, k++);
        res += carry *  Math.pow(2, k);
      }
      return res;
    }
}