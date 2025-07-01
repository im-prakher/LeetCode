class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openIgnore = 0;;
        Set<Integer> open = new HashSet<>();
        Set<Integer> close = new HashSet<>();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '(') {
                open.add(i);
            } else if(str[i] == ')' && open.size() > openIgnore) {
                openIgnore++;
            } else if(str[i] == ')'){
                close.add(i);
            }
        }
        for(int i =0; i< str.length; i++) {
            if((open.contains(i) && openIgnore-- > 0) || (!open.contains(i) && !close.contains(i)))
                sb.append(str[i]);
        }
        return sb.toString();
    }
}