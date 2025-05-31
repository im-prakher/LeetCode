class Solution {
    public String alienOrder(String[] words) {
        if(words.length == 1) {
            char str[]  = words[0].toCharArray();
            Set<Character> set = new HashSet<>();
            for(char ch : str)
                set.add(ch);
            StringBuilder res = new StringBuilder();
            for(char ch : set) 
                res.append(ch);
            return res.toString();
        }
        Map<Character, List<Character>> mp = new HashMap<>();
        Map<Character, Integer> deg = new HashMap<>();
        for (int k = 1; k < words.length; k++) {
            char[] w1 = words[k - 1].toCharArray(), w2 = words[k].toCharArray();
            int n = w1.length, m = w2.length,  a=n, b = m, i = 0, j = 0;
            boolean flag = false;
            while (i < w1.length && j < w2.length) {
                if (!flag && w1[i] != w2[j]) {
                    a = i; b = j;
                    flag = true;
                }
                mp.putIfAbsent(w1[i], new ArrayList<>());
                mp.putIfAbsent(w2[j], new ArrayList<>());
                deg.putIfAbsent(w1[i], 0);
                deg.putIfAbsent(w2[j], 0);
                i++;
                j++;
            }
            while(i < w1.length) {
                mp.putIfAbsent(w1[i], new ArrayList<>());
                deg.putIfAbsent(w1[i], 0);
                i++;
            }
            while(j < w2.length) {
                mp.putIfAbsent(w2[j], new ArrayList<>());
                deg.putIfAbsent(w2[j], 0);
                j++;
            }            
            if(a == n || b == m) {
                if(n > m)
                    return "";
                continue;
            }
            mp.get(w1[a]).add(w2[b]);
            deg.put(w2[b], deg.getOrDefault(w2[b], 0) + 1);
        }

        StringBuilder str = new StringBuilder();
        Queue<Character> que = new LinkedList<>();
        for (char ch : deg.keySet()) {
            if (deg.get(ch) == 0)
                que.offer(ch);
        }
        // if(que.size() == deg.size() && deg.size()!=1)
        //     return "";
        while (!que.isEmpty()) {
            char ch = que.poll();
            str.append(ch);
            for (char neb : mp.get(ch)) {
                deg.put(neb, deg.get(neb) - 1);
                if (deg.get(neb) == 0) {
                    que.offer(neb);
                }
            }
        }
        if(str.length() == deg.size())
            return str.toString();
        return "";
        // Find lexographical diff b/w two words (for [wrt, wrf --> t->f], 
        // [ett, rftt --> e->r)],
        // Based on this diff, create directed graph,(t->f, e->r) 
        // Apply Kahn's topo sort
        // t->f, 
        // w->e,
        // r->t, 
        // e->r
        // return "wertf";
    }
}