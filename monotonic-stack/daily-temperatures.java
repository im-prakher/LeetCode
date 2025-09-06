class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length, top = -1;
        int stack[] = new int[n+1];
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            while(top!=-1 && temps[stack[top]] < temps[i]) {
                ans[stack[top]] = i - stack[top--];
            }
            stack[++top] = i;
        }
        return ans;
    }
}