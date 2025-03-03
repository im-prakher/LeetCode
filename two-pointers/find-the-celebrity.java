/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int k = 0, celeb = 0;
        while(k++ < n) { 
            int j;           
            for(j = 0; j < n; j++) {
                if(celeb == j)
                    continue;
                if(knows(celeb, j)) {
                    celeb = j;
                    break;
                }
            }
            if(j == n)
                break;
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(celeb != i && knows(celeb, i)) 
                return -1;
            if(knows(i, celeb))
                cnt++;
        }
        return cnt == n ? celeb : -1;
    }
}