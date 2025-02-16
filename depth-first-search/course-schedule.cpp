class Solution {
public:
    bool coursePossible(vector <int> gph[], int node, bool *vis, bool *pathVis){
        pathVis[node] = true;
        vis[node] = true;
        for(int v : gph[node]){
            if(!vis[v]){
                if(!coursePossible(gph, v, vis, pathVis))
                    return false;
            }
            else if(pathVis[v])
                return false;
        }
        pathVis[node] =false;
        return true;
    }
    bool canFinish(int n, vector<vector<int>>& edges) {
        vector <int> gph[n];
        for(auto it : edges){
            gph[it[0]].push_back(it[1]);
        }
        bool vis[n], pathVis[n];
        memset(vis, false, sizeof(vis));
        memset(pathVis, false, sizeof(pathVis));
        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(!coursePossible(gph, i, vis, pathVis)){
                    return false;
                }
            }
        }
        return true;
    }
}; 