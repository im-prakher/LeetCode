class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int lft[] = new int[n];
        int rht[] = new int[n];
        for(int i= 0; i < n; i++) {
            lft[i] = rht[i] = i;
        }
        int stack[] = new int[n+1];
        int top = -1;
        for(int i = 0; i < n; i++) {
            while(top!=-1){
                if(heights[stack[top]] > heights[i]) {
                    lft[i] = lft[stack[top]];
                    rht[stack[top]] = i-1;
                    top--;
                } else if(heights[stack[top]] == heights[i]) {
                    lft[i] = lft[stack[top]];
                    break;
                }
                else
                    break;         
            }
            stack[++top] = i;
        }
        int b = stack[top];
        while(top >= 0) {
            rht[stack[top--]] = b;
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, (rht[i] - lft[i] + 1) * heights[i]);
        }
        return ans;
    }
}