class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length - 1;
        int refill = 0, capA = capacityA, capB = capacityB;
        while(i <= j) {
            if(i == j) {
                if(capA >= capB)
                    capA -= plants[i];
                else
                    capB -= plants[i];
            } else {
                capA -= plants[i];
                capB -= plants[j];
            }
            if(capA < 0) {
                capA = capacityA;
                refill++;
            }
            if(capB < 0) {
                capB = capacityB;
                refill++;
            }
            i++; j--;
        }
        return refill;
    }
}