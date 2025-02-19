class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] str = s.toCharArray();
        int i;
        for(i = 0; i < str.length-1; i++) {
            if(str[i] < str[i+1])
                break;
        }
        if(i == str.length - 1)
            return num;
        char max = '0'; int idx = str.length-1;
        for(int j = str.length-1; j > i; j--) {
            if(max < str[j])
                idx = j;
        }
        char tmp = str[i];
        str[i] = str[idx];
        str[idx] = tmp;
        int res = Integer.parseInt(String.valueOf(str));
        return res;
    }
}