class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder s = new StringBuilder();
        int k = 0,n = nums.length; 
        String[] str = new String[n];
        for(int i : nums) {
            str[k++] = String.valueOf(i);
        }
        Arrays.sort(str, (a, b)-> (b+a).compareTo(a+b));
        StringBuilder ans = new StringBuilder();
        if(Integer.parseInt(str[0]) == 0)
            return "0";
        for(int i = 0; i < n; i++) {
            ans.append(str[i]);
        }
        return ans.toString();
    }
}