class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long run = 0, sum = 0;
        for(int i : beans) 
            sum += i;
        long minBean = Long.MAX_VALUE, n = beans.length;
        for(int i = 0; i < n; i++) {
            minBean = Math.min(minBean, sum - (n-i) * beans[i]);
        }
        return minBean;
    }
}