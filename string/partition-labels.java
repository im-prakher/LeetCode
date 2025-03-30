class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[][] idx = new int[26][2];
        for(int[] row : idx) {
            Arrays.fill(row, -1);
        }
        List<int[]> intvs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int cx = s.charAt(i) - 'a';
            idx[cx][0] = idx[cx][0] == -1 ? i : idx[cx][0];
            idx[cx][1] = i;
        }
        for(int i = 0; i < n; i++) {
            if(idx[i][0]!=-1)
                intvs.add(idx[i]);
        }
        intvs.sort((a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);        
        int k = 0;
        for(int i =1; i < intvs.size(); i++) {
            if(intvs.get(k)[1] > intvs.get(i)[0]) {
                intvs.get(k)[1] = Math.max(intvs.get(k)[1], intvs.get(i)[1]);
                intvs.get(i)[0] = -1; intvs.get(i)[1] = -1;
            } else {
                k = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int[] intv : intvs) {
            if(intv[0] != -1)
                ans.add(intv[1] - intv[0] + 1);
        }
        return ans;
    }
}