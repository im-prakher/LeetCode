class Solution {
    Map<Character, List<Character>> cmp;
    Map<String, Integer> dp;
    int MOD = (int)1e9 + 7;
    void initMap() {
        cmp = new HashMap<>();
        cmp.put('*', List.of('a', 'e', 'i', 'o', 'u'));
        cmp.put('a', List.of('e'));
        cmp.put('e', List.of('a', 'i'));
        cmp.put('i', List.of('a', 'e', 'o', 'u'));
        cmp.put('o', List.of('u', 'i'));
        cmp.put('u', List.of('a'));
    }

    public int count(char prv, int i, int n) {
        String key = prv + '_' + String.valueOf(i);
        if(dp.containsKey(key))
            return dp.get(key);
        if(i == n)
            return 1;
        int ans = 0;
        for(char ch : cmp.get(prv)) {
            ans = (ans + count(ch, i + 1, n)) % MOD;
        }
        dp.put(key, ans);
        return ans;
    }

    public int countVowelPermutation(int n) {
        initMap();
        dp = new HashMap<>();
        return count('*', 0, n);
    }
}