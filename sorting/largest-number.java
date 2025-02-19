class Solution {
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
            int i = 0, j = 0;
            while(i < a.length() && j < b.length()) {
                if(a.charAt(i) > b.charAt(j))
                    return -1;
                else if(a.charAt(i) < b.charAt(j))
                    return 1;
                else {
                    i++; j++;
                }
            }
            if(i < a.length()) {
                if(a.charAt(a.length()-1) > b.charAt(j-1))                
                    return -1;
                return 1;
            }
            if(j < b.length()) {
                if(b.charAt(b.length()-1) > a.charAt(i-1))                
                    return 1;
                return -1;
            }
            return 0;
        });

        StringBuilder ans = new StringBuilder();
        for(String n : str) {
            ans.append(n);
        }
        return ans.toString();
    }
}