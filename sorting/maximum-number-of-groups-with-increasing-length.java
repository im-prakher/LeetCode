class Solution {
    public int maxIncreasingGroups(List<Integer> limits) {
        limits.sort((a, b)-> a-b);
        int sum = 0, cnt = 0, n = 0;
        for(int i = 0 ; i < limits.size(); i++) {
            sum += limits.get(i);
            n = (i+1) * (i + 2) / 2; // sum of (i+1)th natural no.s
            if(sum >= n)
                cnt++;
        }
        return cnt;
    }
}