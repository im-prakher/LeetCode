/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for(int i = 0; i < n; i++) {
            if(knows(celeb, i)) {
                celeb = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(celeb == i)
                continue;
            if(knows(celeb, i) || !knows(i, celeb))
                return -1;
        }
        return celeb;
    }
}