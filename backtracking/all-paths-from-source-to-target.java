class Solution {
    public void dfsPaths(int node, int[][] graph, List<Integer> path, List<List<Integer>> ans) {        
        path.add(node);
        if(node == graph.length-1) 
            ans.add(new ArrayList<>(path));
        for(int vtx : graph[node]) {
            dfsPaths(vtx, graph, path, ans);
        }
        path.remove(path.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsPaths(0, graph, path, ans);
        return ans;
    }
}