class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] str = s.toCharArray();
        int n = str.length, idx = str.length-1, k = idx;
        int[] nex = new int[str.length];
        nex[k] = idx;
        for(int j = str.length-2; j >= 0; j--) {
            nex[--k] = (str[idx] > str[j]) ? idx : k;
            if(str[idx] < str[j]) 
                idx = j;
        }
        for(int i = 0; i < n; i++) {
            if(str[nex[i]]!=str[i]) {
                char tmp = str[nex[i]];
                str[nex[i]] = str[i];
                str[i] = tmp;
                break;
            }            
        }
        return Integer.parseInt(String.valueOf(str));
    }
}