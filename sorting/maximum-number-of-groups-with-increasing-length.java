class Solution {
    public int maxIncreasingGroups(List<Integer> limits) {
        limits.sort((a, b)-> a-b);
        int sum = 0, cnt = 0, n = 1, exp = 1;
        for(int i = 0 ; i < limits.size(); i++) {
            sum += limits.get(i);
            exp = n * (n + 1) / 2; // sum of (i+1)th natural no.s
            if(sum >= exp)
                n++;
        }
        return n-1;
    }
}