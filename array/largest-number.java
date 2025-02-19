class Solution {
    public int combine(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(char ch : a.toCharArray()) {
            sb.append(ch);
        }
        for(char ch : b.toCharArray()) {
            sb.append(ch);
        }
        String str = sb.toString();
        int num = 0;
        for(char ch : str.toCharArray()) {
            num = num * 10 + (ch-'0');
        }
        return num;
    }
    public String largestNumber(int[] nums) {
        StringBuilder s = new StringBuilder();
        int k = 0; 
        String[] str = new String[nums.length];
        for(int i : nums) {
            s = new StringBuilder();
            while(i > 0) {
                s.insert(0, (char)('0' + (i % 10)));
                i = i / 10;
            }
            str[k++] = s.toString();
        }
        Arrays.sort(str, (a, b)-> {
            int p = combine(a, b);
            int q = combine(b, a);
            return q-p;
        });

        StringBuilder ans = new StringBuilder();
        for(String n : str) {
            ans.append(n);
        }
        return ans.toString();
    }
}