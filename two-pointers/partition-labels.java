class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int cdx = s.charAt(i) - 'a';
            last[cdx] = i;
        }
        for(int i = 0; i < n; ) {
            int j = last[s.charAt(i)-'a'], k = i;
            while(k < j) {
                int cdx = s.charAt(k) - 'a';
                j = Math.max(j, last[cdx]);
                k++;
            }
            ans.add(j-i+1);
            i = j+1;
        }
        return ans;
    }
}