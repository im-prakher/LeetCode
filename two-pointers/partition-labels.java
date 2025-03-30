class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        List<Integer> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        for(int i = 0; i < n; i++) {
            int cdx = str[i] - 'a';
            last[cdx] = i;
        }
        for(int i = 0; i < n; ) {
            int j = last[str[i] - 'a'], k = i;
            while(k < j) {
                int cdx = str[k] - 'a';
                j = Math.max(j, last[cdx]);
                k++;
            }
            ans.add(j-i+1);
            i = j+1;
        }
        return ans;
    }
}