class Solution {
    public int scoreOfParentheses(String s) {
        int depth=0, score=0;
        char pre = '(';
        for(char ch : s.toCharArray()) {
            if(ch == '(')
                depth++;
            else {
                if(pre == '(') 
                    score += Math.pow(2, depth-1);
                depth--;
            }
            pre = ch;
        }
        return score;
    }
}