class Solution {
    char node[];
    void union(char a, char b) {
        node[a-'a'] = node[b-'a'];
    }

    char find(char a) {
        if(a == node[a-'a'])
            return a;
        return node[a-'a'] = find(node[a-'a']);
    }
    public boolean equationsPossible(String[] equations) {
        node = new char[26];
        for(int i = 0; i < 26; i++) {
            node[i] = (char)('a' + i);
        }
        for(String eqtn : equations) {
            char[] eqn = eqtn.toCharArray();
            char u = find(eqn[0]), v = find(eqn[3]);
            if(eqn[1] == eqn[2]){
                if(u != v) 
                    union(u, v);
            }            
        }
        for(String eqtn : equations) {
            char[] eqn = eqtn.toCharArray();
            char u = find(eqn[0]), v = find(eqn[3]);
            if(eqn[1] != eqn[2] && u == v){
                return false;
            }
        }
        return true;
    }
}