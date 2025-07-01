class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0, moves = 0;
        for(char ch : s.toCharArray()) {
            open += ch =='(' ? 1 : 0;
            close += ch ==')' ? 1 : 0;
            if(close > open) {
                close--;
                moves++;
            }
        }
        return moves + open - close;
    }
}