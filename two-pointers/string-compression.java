class Solution {
    public int compress(char[] str) {
        char[] comp = new char[];
        char prv = '';
        int cnt = 0;
        for(char ch : str) {
            if(prv == ch)
                cnt++;
            else {
                cnt = 0;
                prv = ch;
                
            }
        }
    }
}