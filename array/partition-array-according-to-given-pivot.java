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
    public int[] pivotArray(int[] nums, int pivot) {
        int p0 = 0, curr = 0, p2 = nums.length - 1;
        while(curr <= p2) {
            if(nums[curr] < pivot) {
                swap(p0, curr, nums);
                p0++; curr++;
            } else if(nums[curr] > pivot) {
                swap(p2, curr, nums);
                p2--;
            } else 
                curr++;
        }
        reverse(p2+1, nums.length-1,nums);
        return nums;
    }
}