class Solution {
    public boolean canMake(int[] bloom, int m, int k, int days) {
        int n = bloom.length, pick = 0, cnt = 0;
        for(int i = 0; i < n; i++) {
            if(bloom[i] <= days)
                cnt++;
            else cnt = 0;
            if(cnt == k) {
                pick++;
                cnt = 0;
            }
        }
        return pick >= m;
    }

    public int minDays(int[] bloom, int m, int k) {
        if(bloom.length < m * k)
            return -1;
        int lo = 0, hi = bloom[bloom.length-1];
        for(int i = 0; i < bloom.length; i++) 
            hi = Math.max(hi, bloom[i]);
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi -lo)/2;
            if(canMake(bloom, m, k, mid)) {
                ans = mid;
                hi = mid-1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}