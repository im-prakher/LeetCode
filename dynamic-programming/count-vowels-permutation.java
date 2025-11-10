class Solution {
    Map<Character, List<Character>> cmp;
    Map<Character, Integer> num;
    int dp[][];
    int MOD = (int)1e9 + 7;
    void initMap() {
        cmp = new HashMap<>();
        cmp.put('*', List.of('a', 'e', 'i', 'o', 'u'));
        cmp.put('a', List.of('e'));
        cmp.put('e', List.of('a', 'i'));
        cmp.put('i', List.of('a', 'e', 'o', 'u'));
        cmp.put('o', List.of('u', 'i'));
        cmp.put('u', List.of('a'));

        num = new HashMap<>();
        num.put('*', 0);
        num.put('a', 1);
        num.put('e', 2);
        num.put('i', 3);
        num.put('o', 4);
        num.put('u', 5);
    }

    public int count(char prv, int i, int n) {
        int c = num.get(prv); 
        if(dp[c][i] != -1)
            return dp[c][i];
        if(i == n)
            return 1;
        int ans = 0;
        for(char ch : cmp.get(prv)) {
            ans = (ans + count(ch, i + 1, n)) % MOD;
        }
        return dp[c][i] = ans;
    }

    public int countVowelPermutation(int n) {
        initMap();
        dp = new int[6][n+1];
        for(int[] row : dp) 
            Arrays.fill(row, -1);
        return count('*', 0, n);
    }
}