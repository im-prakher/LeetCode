class Solution {
    public String alienOrder(String[] words) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Map<Integer, Integer> deg = new HashMap<>();
        for(int k = 1; k < words.length; k++) {
            char[] w1 = words[k-1].toCharArray(), w2 = words[k].toCharArray();
            int i = 0, j = 0;
            boolean falg = false;
            while(i < w1.length && j < w2.length) {
                if(!flag && w1[i]!=w2[j]) {
                    a = i; b = j;
                    flag = true;
                }
                mp.putIfAbsent(w1[i], new ArrayList<>());
                mp.putIfAbsent(w2[j], new ArrayList<>());
                deg.putIfAbsent(w1[i], 0);
                i++;
                j++;
            }
            if(i == w1.length || j == w2.length)
                continue;
            mp.get(w1[i]).add(w2[j]);
            deg.put(w2[j], deg.getOrDefault(w2[j], 0) + 1);
        }

        // Find lexographical diff b/w two words (for [wrt, wrf --> t->f], 
        // [ett, rftt --> e->r)],
        // Based on this diff, create directed graph,(t->f, e->r) 
        // Apply Kahn's topo sort
        // t->f, 
        // w->e,
        // r->t, 
        // e->r
        return "wertf";
    }
}