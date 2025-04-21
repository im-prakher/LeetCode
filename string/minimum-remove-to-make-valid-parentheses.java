class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0, close = 0;
        Set<Integer> set = new HashSet<>();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            open += str[i] == '(' ? 1 : 0;
            close += str[i] == ')' ? 1 : 0;
            if(open >= close) {
                open--; close--;
            }
            if(close > open) {
                set.add(i);
                close--;
            }
        }
        open = 0; close = 0;
        for(int i = str.length-1; i >= 0; i--) {
            open += str[i] == '(' ? 1 : 0;
            close += str[i] == ')' ? 1 : 0;
            if(open <= close) {
                open--; close--;
            }
            if(close < open) {
                set.add(i);
                open--;
            }
        }
        for(int i =0; i< str.length; i++) {
            if(!set.contains(i))
                sb.append(str[i]);
        }
        return sb.toString();
    }
}