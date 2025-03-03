/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int out[] = new int[n];
        int in[] = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                if(knows(i, j)) {
                    out[i]++;
                    in[j]++;
                }
            }
        }
        int celeb = -1, c = 0;
        for(int i = 0; i < n; i++) {
            if(out[i] == 0 && in[i] == n-1) {
                celeb = i;
                c++;
            }
        }
        return c > 1 ? -1 : celeb;
    }
}