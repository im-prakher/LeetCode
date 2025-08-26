class Solution {
    public int solve(int[] dp, int[] costs, TreeSet<Integer> tset, Integer day) {
        if(day == null || day > tset.last())
            return 0;
        if(dp[day]!=-1)
            return dp[day];
        return dp[day] =  Math.min(costs[0] + solve(dp, costs, tset, tset.ceiling(day + 1)),
            Math.min(
                costs[1] + solve(dp, costs, tset, tset.ceiling(day + 7)),
                costs[2] + solve(dp, costs, tset, tset.ceiling(day + 30))
            )
        );
    }

    public int mincostTickets(int[] days, int[] costs) {
        TreeSet<Integer> tset = new TreeSet<>();
        for(int d : days) {
            tset.add(d);
        }
        int[] dp = new int[366];
        Arrays.fill(dp, -1);
        return solve(dp, costs, tset, days[0]);
    }
}