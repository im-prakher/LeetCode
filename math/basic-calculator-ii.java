class Solution {
    public boolean isAddSub(char op) {
        return op == '-' || op == '+';
    }
    
    public int getSign(char op) {
        return op == '-' ? -1 : 1;
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] str = s.toCharArray();
        int sum = str[0] - '0', sign = 1, eval = 0;
        for(int i = 1; i < str.length-1; i+=2) {
            char op = str[i];
            int dig = str[i+1]-'0';
            if(isAddSub(op)) {
                eval += sign * sum;
                sign = getSign(op);
                sum = dig;
            }
            else if(op == '/') 
                sum /= dig;
            else 
                sum *= dig;
        }
        eval += sign * sum;
        return eval;
    }
}