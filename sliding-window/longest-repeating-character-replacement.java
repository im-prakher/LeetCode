class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        char str[] = s.toCharArray();
        int maxFreq = 0, res = 0;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for(int i = 0, j = -1; i < str.length; i++) {
            int idx = str[i] - 'A';
            tmap.put(++freq[idx], tmap.getOrDefault(freq[idx], 0) + 1);
            maxFreq = tmap.lastKey();
            while(i - j - maxFreq > k) {
                int key = freq[str[++j]-'A'];
                if(tmap.get(key) == 1)
                    tmap.remove(key);
                else
                    tmap.put(key, tmap.get(key)-1);
                tmap.put(--freq[str[j]-'A'], tmap.getOrDefault(freq[str[j]-'A'],0) +1);
                maxFreq = tmap.lastKey();
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
}