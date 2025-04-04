class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Thread t1 = new Thread(() -> Arrays.sort(g));
        Thread t2 = new Thread(() -> Arrays.sort(s));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {}
        int i =0, j=0, m = g.length, n = s.length, cnt = 0;
        while(i < m && j < n){
            if(g[i] <= s[j]){
                cnt++;
                i++; j++;
            }
            else
                j++;
        }
        return cnt;
    }
}