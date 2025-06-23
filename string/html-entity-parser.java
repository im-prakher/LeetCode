class Solution {
    public String entityParser(String text) {
        char[] str = text.toCharArray();
        StringBuilder res = new StringBuilder();
        int n = text.length();
        Map<String, String> mp = new HashMap<>();
        mp.put("&quot;", "\"");
        mp.put("&apos;", "\'");
        mp.put("&amp;", "&");
        mp.put("&gt;", ">");
        mp.put("&lt;", "<");
        mp.put("&frasl;", "/");
        for(int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();
            if(str[i] == '&') {
                while(i < n) {
                    word.append(str[i++]);
                    if(mp.containsKey(word.toString())) {
                        word = new StringBuilder(mp.get(word.toString()));
                        i--;
                        break;
                    }
                    if(i < n && str[i] == '&') {
                        i--; break;
                    }
                }
            } else {
                word.append(str[i]);
            }
            res.append(word);
        }
        return res.toString(); 
    }
}