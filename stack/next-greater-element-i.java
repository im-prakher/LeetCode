class Solution {
    int[] stack = new int[1020];
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int top = -1;
        int nge[] = new int[nums1.length];
        int map[] = new int[100_01];
        for(int i = nums2.length-1; i >= 0; i--) {
            while(top!=-1 && nums2[i] > nums2[stack[top]]) 
                top--;
            map[nums2[i]] = top!= -1 ? nums2[stack[top]] : -1;
            stack[++top] = i;
        }
        for(int i = 0; i < nums1.length; i++) {
            nge[i] = map[nums1[i]];
        }
        return nge;
    }
}