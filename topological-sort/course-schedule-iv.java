class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] preq, int[][] qrys) {
        List<Integer> adj[] = new List[n];
        int inDeg[] = new int[n];
        BitSet preqDb[] = new BitSet[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            preqDb[i] = new BitSet(n);
        }
        for(int[] pre : preq) {
            adj[pre[0]].add(pre[1]);
            inDeg[pre[1]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDeg[i] == 0)
                que.offer(i);
        }

        while(!que.isEmpty()) {
            int node = que.poll();
            for(int vtx : adj[node]) {
                preqDb[vtx].set(node);
                preqDb[vtx].or(preqDb[node]);
                if(--inDeg[vtx] == 0)
                    que.offer(vtx);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] qry : qrys) {
            res.add(preqDb[qry[1]].get(qry[0]));
        }
        return res;
    }
}