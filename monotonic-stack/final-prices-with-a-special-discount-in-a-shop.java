class Solution {
    public int[] finalPrices(int[] prices) {
        int[] stack = new int[1002];
        int top = -1, n = prices.length, k = n-1;
        int ans[] = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(top != -1 && stack[top] > prices[i]) {
                top--;
            }
            ans[k--] = prices[i] - (top == -1 ? 0 : stack[top]);
            stack[++top] = prices[i];
        }
        return ans;
    }
}