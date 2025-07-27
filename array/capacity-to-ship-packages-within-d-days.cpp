class Solution {
public:
    bool checkCapacity(vector<int> weights, int n, int cap, int days){
        int allocatedDays = 1, total = 0;
        for(int i=0; i < n; i++){
            if(weights[i] > cap)
                return false;
            if(total + weights[i] > cap){
                total = 0;
                allocatedDays++;
            }
            total += weights[i];
        }
        return allocatedDays <= days;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int lo = INT_MAX , hi=0, n= weights.size();
        for(int i : weights){
            lo = min(lo, i);
            hi += i;
        }
        // int ans =0;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(checkCapacity(weights, n, mid, days)){
                hi = mid-1;
                // ans = mid;
            }
            else
                lo = mid + 1;
        }
        return lo;
    }
};