class Solution {
    public int hash(String s) {
        int hash = 0;
        for(char ch : s.toCharArray()) {
            hash = hash * 10 + (ch-'a');
        }
        return hash;
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a); 
        int cnt = 1;       
        while(sb.length() <= b.length()) {
            sb.append(a);
            cnt++;
        }
        int hash_b = hash(b), i, len = b.length();
        int hash_a = hash(sb.substring(0, len));
        for(i = 0; i < sb.length() - b.length(); i++) {
            if(i != 0) {
                int cf = sb.charAt(i-1) - 'a', cl = sb.charAt(i+len-1) - 'a';
                hash_a = (hash_a - (int) Math.pow(10, b.length())) * 10 + cl;  
            }
            if(hash_b == hash_a) {
                break;
            }
        }
        return i+len == b.length() ? cnt - 1 : cnt;
    }
}