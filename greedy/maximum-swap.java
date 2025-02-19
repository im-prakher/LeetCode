class Solution {
    public int maximumSwap(int num) {
        char str[] = String.valueOf(num).toCharArray();
        int n = str.length, mxIdx = -1, sp = n-1, sq = n-1;
        for(int i = n-1; i >= 0; i--) {
            if(mxIdx == -1 || str[mxIdx] < str[i])
                mxIdx = i;
            else if(str[i] != str[mxIdx]){
                sp = mxIdx;
                sq = i;
            }
        }
        char tmp = str[sp];
        str[sp]  = str[sq];
        str[sq]  = tmp;
        return Integer.valueOf(String.valueOf(str));
    }
}