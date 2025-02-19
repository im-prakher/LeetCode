class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0, bal = 0;
        for(char ch : s.toCharArray()) {
            open += ch == '(' ? 1 : 0;
            close += ch == ')' ? 1 : 0;
            if(close > open) {
                bal++;
                close--;
            }
        }
        return bal + open - close;
    }
}