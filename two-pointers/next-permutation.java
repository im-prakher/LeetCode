class Solution {
    void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public void reverse(int i, int j, int[] nums) {
        while(i < j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++; j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length, i, j;
        for(i = n - 1; i >= 1; i--) 
            if(nums[i-1] < nums[i])
                break;
        if(i != 0) {
            for(j = n-1; j >= i; j--) 
                if(nums[j] > nums[i-1])
                    break;
            swap(i-1, j, nums);
        }
        reverse(i, n-1, nums);
    }
}