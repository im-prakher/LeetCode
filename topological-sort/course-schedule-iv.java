class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] preq, int[][] qrys) {
        List<Integer> adj[] = new List[n];
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        int inDeg[] = new int[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            mp.put(i, new HashSet<>());
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
                mp.get(vtx).add(node);
                mp.get(vtx).addAll(mp.get(node));
                if(--inDeg[vtx] == 0)
                    que.offer(vtx);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] qry : qrys) {
            res.add(mp.get(qry[1]).contains(qry[0]));
        }
        return res;
    }
}