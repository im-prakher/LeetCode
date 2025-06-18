class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {        
        List<Integer> ans = new ArrayList<>();
        int n = security.length, days = 0;
        int[] inc = new int[n];
        int[] dec = new int[n];
        for(int i = 1, j = n-2; i < n && j >= 0; i++, j--) {
            if(security[i-1] >= security[i])
                inc[i] = inc[i-1] + 1;
            if(security[j] <= security[j+1])
                dec[j] = dec[j+1] + 1;
        }
        for(int i = 0 ; i < n; i++) {
            if(inc[i] >= time && time <= dec[i])
                ans.add(i);
        }
        return ans;
    }
}