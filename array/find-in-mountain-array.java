/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int getMaxIdx(MountainArray mountainArr, int n) {
        int i = 0, j = n-1;
        while(i < j) {
            int mid = (i + j) >> 1;
            if(mountainArr.get(mid-1) < mountainArr.get(mid))
                i = mid;
            else
                j = mid - 1;
        }
        return i;
    }

    public int search(MountainArray mountainArr, int target, int i, int j, boolean flag) {
        int ans = -1;
        while(i < j) {
            int mid = (i + j) >> 1;
            int found = mountainArr.get(mid);
            if(found == target) {
                ans = mid;
            } 
            if(!flag) {
                if(found < target)
                    i = mid + 1;
                else
                    j = mid - 1;
            } else {
                if(found <= target)
                    j = mid - 1;
                else
                    i = mid + 1;
            }
        }
        return ans;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int k = getMaxIdx(mountainArr, n);
        int a = search(mountainArr, target, 0, k, false);
        int b = search(mountainArr, target, k+1, n-1, true);
        return a != -1 ? a : b;
    }
}