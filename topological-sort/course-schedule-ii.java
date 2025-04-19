class Solution {
    public int[] findOrder(int num, int[][] preq) {
        // Arrays.fill(adj, new ArrayList<>());--> will fill each adj[i] with same list reference so don't use as insertion at one index will insert at all indexes
        List<Integer> adj[] = new List[num];
        for(int i = 0; i < num; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] inDeg = new int[num];
        for(int[] pre : preq) {
            adj[pre[0]].add(pre[1]);
            inDeg[pre[1]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < num; i++) {
            if(inDeg[i] == 0)
                que.offer(i);
        }

        int idx = num;
        int[] order = new int[num];
        while(!que.isEmpty()) {
            int node = que.poll();
            order[--idx] = node;
            for(int vtx : adj[node]) {
                if(--inDeg[vtx] == 0)
                    que.offer(vtx);
            }
        }
        return idx == 0 ? order : new int[0];
    }
}