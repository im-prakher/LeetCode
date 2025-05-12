class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2, j = n - 1, k;
        while(i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i != -1) {
            for (k = n - 1; k > i; k--) {
                if (nums[k] > nums[i])
                    break;
            }
            swap(i, k, nums);
        }
        reverse(i + 1, n - 1, nums);
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}