class Solution {
    void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0, p2 = nums.length-1;
        while(curr <= p2) {
            if(nums[curr] == 0) {
                swap(p0, curr, nums);
                p0++; curr++;
            } else if (nums[curr] == 2) {
                swap(p2, curr, nums);
                p2--;
            } else
                curr++;
        }
    }
}