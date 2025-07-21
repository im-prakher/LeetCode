class Solution {
    boolean isZero(int[] nums, int[][] qrys, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int[] qry = qrys[i];
            diff[qry[0]] += qry[2];
            diff[qry[1] + 1] -= qry[2];
        }
        int dec = 0;
        for (int i = 0; i < n; i++) {
            dec += diff[i];
            if (nums[i] > dec)
                return false;
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] qrys) {
        int i = 0, j = qrys.length, ans = -1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (isZero(nums, qrys, mid)) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
}