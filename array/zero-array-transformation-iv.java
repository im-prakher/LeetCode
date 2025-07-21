class Solution {
    public int minZeroArray(int[] nums, int[][] qrys) {
        // Line Sweep
        int n = nums.length;
        int[] diff = new int[n + 1];
        int k = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            while(sum + diff[i] < nums[i]) {
                if(k == qrys.length)
                    return -1;
                int[] qry = qrys[k++];
                // qry not useful, as previous idx's can already be 0, so skip
                if(qry[1] < i)
                    continue;
                diff[Math.max(qry[0], i)] += qry[2];
                diff[qry[1]+1] -= qry[2];
            }
            sum += diff[i];
        }
        return k;
    }
}

