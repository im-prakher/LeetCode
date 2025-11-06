class Solution {
    public int[] processQueries(int c, int[][] conn, int[][] queries) {
        Map<Integer, Boolean> active = new HashMap<>();
        Map<Integer, TreeSet<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= c; i++) {
            active.put(i, true);
            adj.putIfAbsent(i, new TreeSet<>((a, b)-> a - b));
        }
        for(int[] con : conn) {
            adj.get(con[0]).add(con[1]);
            adj.get(con[1]).add(con[0]);
        }
        List<Integer> res = new ArrayList<>();
        for(int[] qry: queries) {
            if(qry[0] == 2)
                active.put(qry[1], false);
            else if(active.get(qry[1]))
                res.add(qry[1]);
            else {
                int stat = -1;
                for(int i :  adj.get(qry[1])) {
                    if(active.get(i)) {
                        stat = i;
                        break;
                    }
                }
                res.add(stat);
            }
        }
        int[] ans = res.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}