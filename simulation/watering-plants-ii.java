class Solution {
    public int minimumRefill(int[] plants, int capA, int capB) {
        int i = 0, j = plants.length - 1;
        int refill = 0, alice = capA, bob = capB;
        while (i < j) {
            if (alice < plants[i]) {
                alice = capA;
                refill++;
            }
            if (bob < plants[j]) {                
                bob = capB;
                refill++;
            }
            alice -= plants[i++];
            bob -= plants[j--];
        }
        if (i == j) {
            if(alice >= bob) 
                refill += (plants[i] > alice) ? 1 : 0;
            else
                refill += (plants[i] > bob) ? 1 : 0;
        }
        return refill;
    }
}