class Solution {
    public int maxIncreasingGroups(List<Integer> limits) {
        limits.sort((a, b)-> a-b);
        long sum = 0, n = 0, exp = 1;
        for(int i = 0 ; i < limits.size(); i++) {
            sum += limits.get(i);
            exp = (n + 1) * (n + 2) / 2; // sum of (i+1)th natural no.s
            if(sum >= exp)
                n++;
        }
        return (int)n;
    }
}