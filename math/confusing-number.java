class Solution {
    Map<Integer, Integer> mp;
    public boolean confusingNumber(int n) {
        mp = new HashMap<>();
        mp.put(0, 0);
        mp.put(1, 1);
        mp.put(6, 9);
        mp.put(8, 8);
        mp.put(9, 6);
        int num = n, res = 0;
        while(num > 0) {
            if(!mp.containsKey(num % 10))
                return false;
            res = res * 10 + mp.get(num % 10);
            num /= 10;
        }
        return res != n;
    }
}