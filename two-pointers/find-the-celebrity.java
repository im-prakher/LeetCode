/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cnt[] = new int[n];
        Set<Integer> popular = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                if(knows(i, j)) {
                    popular.add(j);
                    cnt[i]++;
                }
            }
        }
        if(popular.size() == n)
            return -1;
        int celeb = -1, c = 0;
        for(int i = 0; i < n; i++) {
            if(cnt[i] == 0) {
                celeb = i;
                c++;
            }
            if(c > 1)
                return -1;
        }
        return celeb;
    }
}