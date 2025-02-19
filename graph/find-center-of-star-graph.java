class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 2;
        List<Integer> adj[] = new List[n];
        for(int i =0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int i = 0;
        for(List<Integer> list : adj) {
            if(list.size() == n-2)
                return i;
            i++;
        }
        return 0;
    }
}