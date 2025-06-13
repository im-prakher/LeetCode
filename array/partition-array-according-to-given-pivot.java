class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int a = 0, n = nums.length, b = n-1;
        int ans[] = new int[n];
        for(int i = 0, j = b; i < n; i++, j--) {
            if(nums[i] < pivot)
                ans[a++] = nums[i];
            if(nums[j] > pivot)
                ans[b--] = nums[j];
        }
        for(int k = a; k <=b; k++) 
            ans[k] = pivot;
        return ans;
    }
}