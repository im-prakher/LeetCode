class Solution {
    public boolean canBeValid(String s, String locked) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder lock = new StringBuilder(locked);
        return isValid(sb.toString(), lock.toString()) 
                ;
    }
    public boolean isValid(String s, String locked) {
        if(s.length() % 2 != 0)
            return false;
        int closeUnlock = 0, open = 0, close = 0, change = 0;
        char[] str = s.toCharArray();
        char[] lock = locked.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            close += str[i] == ')' ? 1 : 0;
            open += str[i] == '(' ? 1 : 0;
            closeUnlock += str[i] == ')' && lock[i] == '0' ? 1 : 0;
            if(close > open) { 
                if(closeUnlock > 0) {
                    closeUnlock--;
                    open++;
                    close--;
                    change++;
                } else {
                    return false;
                }
            }
        }
        for(int i = 0; change > 0 && i < str.length; i++) {
            if(str[i] == ')' && lock[i] == '0') {
                str[i] = '(';
                change--;
            }
        }

        closeUnlock = 0; open = 0; close = 0;
        for(int i = s.length()-1; i >= 0 ; i--) {
            close += str[i] == '(' ? 1 : 0;
            open += str[i] == ')' ? 1 : 0;
            closeUnlock += str[i] == '(' && lock[i] == '0' ? 1 : 0;
            if(close > open) { 
                if(closeUnlock > 0) {
                    closeUnlock--;
                    open++;
                    close--;
                } else {
                    return false;
                }
            }
        }
        // if(close > open)
        //     close unlocked cnt > 0 & open++
        return open == close;
    }
}