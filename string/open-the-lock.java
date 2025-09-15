class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))
            return 0;
        Queue<String> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        for(var ends : deadends)
            vis.add(ends);
        if(vis.contains("0000"))
            return -1;
        que.offer("0000");
        Map<String, Integer> mp = new HashMap<>();
        mp.put("0000", 0);
        while(!que.isEmpty()) {
            String s = que.poll();
            for(int i = 0; i < 4; i++) {
                char[] atr = s.toCharArray();
                char[] ntr = atr.clone();
                atr[i] = (atr[i] == '9') ? '0' : (char) (atr[i] + 1);
                ntr[i] = (ntr[i] == '0') ? '9' : (char) (ntr[i] - 1);
                String a = new String(atr);
                String n = new String(ntr);
                if(a.equals(target) || n.equals(target)) 
                    return mp.get(s) + 1;
                if(!vis.contains(a)) {
                    que.offer(a);
                    mp.put(a, mp.get(s) + 1);
                }
                if(!vis.contains(n) ){
                    que.offer(n);    
                    mp.put(n, mp.get(s) + 1);
                }
                vis.add(a);
                vis.add(n);
            }
        }
        return -1;
    }
}