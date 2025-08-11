class Solution {
    public int minTransfers(int[][] transactions) {
        int bal[] = new int[12];
        for(int[] tran : transactions) {
            int from = tran[0], to = tran[1], amt = tran[2];
            bal[from] -= amt;
            bal[to] += amt;
        }
        int cnt = 0;
        for(int rem : bal) {
            if(rem != 0)
                cnt++;
        }
        return (cnt + 1) / 2;
    }
}