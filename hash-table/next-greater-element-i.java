class Solution {
    int[] stack = new int[1020];
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int top = -1;
        int nge[] = new int[nums1.length];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = nums2.length -1 ; i >= 0; i--) {
            while(top != -1 && nums2[stack[top]] <= nums2[i])
                top--;
            mp.put(nums2[i], top == -1 ? top : nums2[stack[top]]);
            stack[++top] = i;
        }
        for(int i = 0; i < nums1.length; i++) {
            nge[i] = mp.get(nums1[i]);
        }
        return nge;
    }
}