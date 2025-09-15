class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))
            return 0;
        Queue<String> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        Set<String> ends = new HashSet<>();
        for(var dead : deadends)
            ends.add(dead);
        if(ends.contains("0000"))
            return -1;
        que.offer("0000");
        Map<String, Integer> mp = new HashMap<>();
        mp.put("0000", 0);
        while(!que.isEmpty()) {
            String s = que.poll();
            char[] atr = s.toCharArray();
            char[] ntr = atr.clone();
            for(int i = 0; i < 4; i++) {
                char ch = atr[i];
                atr[i] = (ch == '9') ? '0' : (char) (ch + 1);
                ntr[i] = (ch == '0') ? '9' : (char) (ch - 1);
                String a = new String(atr);
                String n = new String(ntr);
                if(a.equals(target) || n.equals(target)) 
                    return mp.get(s) + 1;
                if(!vis.contains(a) && !ends.contains(a)) {
                    que.offer(a);
                    mp.put(a, mp.get(s) + 1);
                }
                if(!vis.contains(n) && !ends.contains(n)) {
                    que.offer(n);    
                    mp.put(n, mp.get(s) + 1);
                }
                vis.add(a);
                vis.add(n);
                atr[i] = ntr[i] = ch;
            }
        }
        return -1;
    }
}