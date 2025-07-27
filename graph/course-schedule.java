class Solution {
    public boolean canFinish(int num, int[][] prereq) {
        List<Integer> adj[] = new List[num];
        for(int i = 0; i < num; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] inDeg = new int[num];
        for(int[] pre : prereq) {
            adj[pre[1]].add(pre[0]);
            inDeg[pre[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < num; i++) {
            if(inDeg[i] == 0)
                que.offer(i);
        }

        while(!que.isEmpty()) {
            int node = que.poll();
            for(int vtx : adj[node]) {
                if(--inDeg[vtx] == 0)
                    que.offer(vtx);
            }
        }
        for(int i = 0; i < num; i++) {
            if(inDeg[i] != 0)
                return false;
        }
        return true;
    }
}