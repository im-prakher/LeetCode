class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int a = 0, n = nums.length, b = n-1;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(nums[i] < pivot)
                ans[a++] = nums[i];
        }
        for(int j = n-1; j >= 0; j--) {
            if(nums[j] > pivot)
                ans[b--] = nums[j];
        }
        for(int k = a; k <=b; k++) 
            ans[k] = pivot;
        return ans;
    }
}