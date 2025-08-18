class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length(), step = 0;
        int move[] = new int[n+1];
        for(int shift[] : shifts) {
            move[shift[0]] += shift[2] == 0 ? -1 : 1;
            move[shift[1]+1] += shift[2] == 0 ? 1 : -1;
        }
        char[] str = s.toCharArray();
        int a = 'a', z = 'z';
        for(int i = 0; i < n; i++) {
            step += move[i];
            if(step == 0)
                continue;
            int skip = (int) str[i] + step;
            if(skip < a) 
                str[i] =  (char) (skip + 26);
            else if(skip > z)
                str[i] =  (char) (skip - 26);
            else
                str[i] = (char) skip;
        }
        return new String(str);
    }
}