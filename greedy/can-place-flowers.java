class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
     int lnt = 0, rnt =0;
     int nums[] = new int[flowerbed.length+3];
     for(int i = 1; i <= n; i++) 
        nums[i] = flowerbed[i-1];
     for(int i = 1, j = 2; i < flowerbed.length; i+=2, j+=2) {
            if(nums[i-1] == 0 && nums[i] == 0 && nums[i+1] == 0)
                lnt++;
            if(nums[j] == 0 && nums[j-1]==0 && nums[j+1] == 0)
                rnt++;
        }
        if(lnt == n || rnt == n)
            return true;
        return false;
    }
}