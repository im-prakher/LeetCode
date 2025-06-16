class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0, n = start.length();
        char[] tgr = target.toCharArray();
        char[] str = start.toCharArray();
        while(i < n && j < n) {
            if(tgr[i] != '_') {
                while(j < n && str[j] == '_') {
                    j++;
                }
                if(tgr[i] == str[j]) {
                    if(tgr[i] == 'L' && i > j)
                        return false;
                    else if(tgr[i] == 'R' &&  j > i)
                        return false;
                } else
                    return false;
                j++;
            } 
            i++;
        }
        while(i < n) {
            if(tgr[i++] != '_') 
                return false;
        }
        while(j < n) {
            if(str[j++] != '_') 
                return false;
        }
        return true;
    }
}