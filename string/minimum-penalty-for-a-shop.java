class Solution {
    public int bestClosingTime(String customers) {
        char[] cust = customers.toCharArray();
        int n = cust.length;
        int[] onClose = new int[n+2];
        int[] onOpen = new int[n+2];
        for(int i = 1; i <= n; i++) {
            onClose[i] += onClose[i-1] + (cust[i-1] == 'Y' ? 1 : 0);
            onOpen[i] += onOpen[i-1] + (cust[i-1] == 'N' ? 1 : 0);
        }
        onClose[n+1] = onClose[n];
        onOpen[n+1] = onOpen[n];
        int ans = 0, min = onClose[n+1] - onClose[0] + onOpen[0];
        int penalty;
        for(int i = 2; i <= n+1; i++) {
            penalty = onClose[n+1] - onClose[i-1] + onOpen[i-1];
            if(min > penalty) {
                ans = i-1;
                min = penalty;
            }
        }
        return ans;
    }
}