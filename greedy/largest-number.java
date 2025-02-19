class Solution {
    public long combine(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(char ch : a.toCharArray()) {
            sb.append(ch);
        }
        for(char ch : b.toCharArray()) {
            sb.append(ch);
        }
        String str = sb.toString();
        long num = 0;
        for(char ch : str.toCharArray()) {
            num = num * 10 + (int)(ch-'0');
        }
        return num;
    }
    public String largestNumber(int[] nums) {
        StringBuilder s = new StringBuilder();
        int k = 0,n = nums.length; 
        String[] str = new String[n];
        for(int i : nums) {
            s = new StringBuilder();
            if(i!=0) {
                while(i > 0) {
                    s.insert(0, (char)('0' + (i % 10)));
                    i = i / 10;
                }
            } else
                s.append("0");
            str[k++] = s.toString();
        }
        Arrays.sort(str, (a, b)-> {
            long p = combine(a, b);
            long q = combine(b, a);
            if(p > q)
                return -1;
            return 1;
        });

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(i!=0 && equalsZero(str[i-1], str[i]))
                continue;
            ans.append(str[i]);
        }
        return ans.toString();
    }
    public boolean equalsZero(String a, String b) {
        int p = Integer.parseInt(a);
        int q = Integer.parseInt(b);
        return p==0 && p==q;
    }
}