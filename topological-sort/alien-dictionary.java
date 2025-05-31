class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> mp = new HashMap<>();
        Map<Character, Integer> deg = new HashMap<>();
        for (int k = 1; k < words.length; k++) {
            char[] w1 = words[k - 1].toCharArray(), w2 = words[k].toCharArray();
            int a = w1.length, b = w2.length, i = 0, j = 0;
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
            if (a == w1.length || b == w2.length)
                continue;
            mp.get(w1[a]).add(w2[b]);
            deg.put(w2[b], deg.getOrDefault(w2[b], 0) + 1);
        }

        StringBuilder str = new StringBuilder();
        Queue<Character> que = new LinkedList<>();
        for (char ch : deg.keySet()) {
            if (deg.get(ch) == 0)
                que.offer(ch);
        }

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
        return str.toString();
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