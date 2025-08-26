class Solution {
     int[] dp;
    public int solve(int[] costs, TreeSet<Integer> tset, Integer day) {
        if(day == null || day > tset.last())
            return 0;
        if(dp[day]!=-1)
            return dp[day];
        Integer nextDay1 = tset.ceiling(day + 1);
        Integer nextDay2 = tset.ceiling(day + 7);
        Integer nextDay3 = tset.ceiling(day + 30);
        return dp[day] =  Math.min(costs[0] + solve(costs, tset, nextDay1),
            Math.min(
                costs[1] + solve(costs, tset, nextDay2),
                costs[2] + solve(costs, tset, nextDay3)
            )
        );
    }

    public int mincostTickets(int[] days, int[] costs) {
        TreeSet<Integer> tset = new TreeSet<>();
        for(int d : days) {
            tset.add(d);
        }
        dp = new int[366];
        Arrays.fill(dp, -1);
        return solve(costs, tset, days[0]);
    }
}