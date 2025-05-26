class Solution {
public:
    void dfs(int i, int j, vector<vector<int>>& grid, int c){
        if(i<0 || i>=grid.size() || j<0 || j>=grid[0].size() || !grid[i][j] || (grid[i][j]>=2 && grid[i][j]<c)) return;
        // cout<<i<<" "<<j<<" "<<c<<"\n";
        grid[i][j]=c;
        c++;
        dfs(i+1,j,grid,c);
        dfs(i-1,j,grid,c);
        dfs(i,j+1,grid,c);
        dfs(i,j-1,grid,c);
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(), ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2) {
                    dfs(i,j,grid,2);
                }
            }
        }
        int ok = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2) ok=1;
                if(grid[i][j]==1) return -1;
                ans = max(ans,grid[i][j]);
            }
        }
        if(!ok) return 0;
        return ans-2;
    }
};