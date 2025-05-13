class Solution {
    public int max(int[] arr) {
        int n = arr.length, max = arr[0], left = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                left = 1;
                 max = Math.max(max, arr[i]);
                continue;
            }
            left *= arr[i];
            max = Math.max(max, left);
        }
        return max;
    }
    public int maxProduct(int[] arr) {
        int max1 = max(arr), n = arr.length;
        for(int i = 0 ; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = tmp;
        }
        return Math.max(max1, max(arr));
    }
}