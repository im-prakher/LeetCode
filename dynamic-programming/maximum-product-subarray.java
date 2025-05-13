class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length, max1 = arr[0], max2 = arr[n-1], left = max1, right = max2;
        for(int i = 1; i < arr.length; i++) {
            left *= arr[i]; right *= arr[n-i-1];
            max1 = Math.max(max1, left);
            max2 = Math.max(max2, right);
        }
        return Math.max(max1, max2);
    }
}