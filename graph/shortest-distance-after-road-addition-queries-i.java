class Solution {
    public void dfsReduce(int node, List<Integer> adj[], int[] dist) {
        for(int vtx : adj[node]) {
            if(dist[vtx] > dist[node] + 1) {
                dist[vtx] = dist[node] + 1;
                dfsReduce(vtx, adj, dist);
            }
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
     //use topo sort: 0->1->..->n-1
     //maintain distance array
     //reduce dist for next nodes after one query in topo sort 
    List<Integer> adj[] = new List[n];
    int dist[] = new int[n];
    for(int i = 0; i < n; i++) {
        dist[i] = n-i-1;
        adj[i] = new ArrayList();
        if(i!=0)
            adj[i].add(i-1);
    }
    int[] ans = new int[queries.length];
    int k = 0;
    for(int[] qry : queries) {
        if(dist[qry[0]] > dist[qry[1]] + 1) {
            dist[qry[0]] = dist[qry[1]] + 1;
            adj[qry[1]].add(qry[0]);
            dfsReduce(qry[0], adj, dist);
        }        
        ans[k++] = dist[0];
    }
    return ans;
    }
}