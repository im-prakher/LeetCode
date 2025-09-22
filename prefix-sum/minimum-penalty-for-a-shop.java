class Solution {
    public int bestClosingTime(String customers) {
        int visit = 0, no_visit = 0;
        char[] cust = customers.toCharArray();
        // for(char ch : cust) {
        //     visit += (ch == 'Y') ? 1 : 0;
        // }
        int ans = -1, min = cust.length;
        for(int i = 0; i <= cust.length; i++) {
            if(min > visit + no_visit) {
                min = visit + no_visit;
                ans = i;
            }
            if(i == cust.length)
                break;
            visit -= cust[i] == 'Y' ? 1 : 0;
            no_visit += cust[i] == 'N' ? 1 : 0;
        }
        return ans;
    }
}