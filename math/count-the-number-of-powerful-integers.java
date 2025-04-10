class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suf = Long.valueOf(s);
        if(suf > finish)
            return 0; 
        if(suf == finish)
            return 1;
        long base = (long) Math.pow(10, s.length());
        int cnt = 0;
        while(base <= finish) {
            if(base * 10 > finish)
                cnt += Math.min(finish / base, limit);
            else cnt += limit;
            base *= 10;
        }
        cnt += suf >= start ? 1 : 0;
        return cnt ;
    }
}