class Solution {
    public int findCircleNum(int[][] arr) {
        int [] vis=new int [arr.length+1];
        int cnt=0;
        for(int i=1;i<arr.length+1;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,arr,vis);
            }
        }
        return cnt;
    }
    void dfs(int node,int [][] arr,int [] vis){
        vis[node]=1;
        for(int i=1;i<arr.length+1;i++){
            if(vis[i]==0 && arr[node-1][i-1]==1){
                dfs(i,arr,vis);
            }
        }
    }
}