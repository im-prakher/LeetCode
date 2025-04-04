class Solution {
    public boolean canEat(int[] piles, int k, int h) {
        if(k == 0)
            return false;
        int time = 0;
        for(int p : piles) {
            time += p/k + (p % k == 0 ? 0 : 1);
        }
        return time <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 0, hi = piles[piles.length-1], k = piles[0];
        for(int i = 0; i < piles.length; i++) 
            hi = Math.max(hi, piles[i]);
        while(lo <= hi) {
            int mid = (lo + hi) >> 1;
            if(canEat(piles, mid, h)) { 
                k = mid;    
                hi = mid - 1;
            }
            else 
                lo = mid + 1;
        }
        return k;
    }
}