class Solution {
    public boolean isAddSub(char op) {
        return op == '-' || op == '+';
    }
    
    public int getSign(char op) {
        return op == '-' ? -1 : 1;
    }

    public boolean isDig(char ch) {
        return ch >= '0' && ch <='9';
    }

    public int[] getDigit(char[] str, int idx) {
        int dig = 0;
        while(idx < str.length && isDig(str[idx])) {
            dig = dig * 10 + (str[idx] - '0');
            idx++;
        }
        return new int[] {dig, idx};
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] str = s.toCharArray();
        int[] digit = getDigit(str, 0);
        int sum = digit[0], sign = 1, eval = 0;
        for(int i = digit[1]; i < str.length; i = digit[1]) {
            char op = str[i];
            digit = getDigit(str, i+1);
            int dig = digit[0];
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