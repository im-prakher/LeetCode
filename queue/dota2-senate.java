class Solution {
    public String predictPartyVictory(String senate) {
        int cntR = 0, cntD = 0, revR= 0, revD= 0;
        Queue<Character> que = new LinkedList<>();
        for(char s : senate.toCharArray()) {
            que.offer(s);
            cntR += s == 'R'? 1: 0;
            cntD += s == 'D'? 1: 0;
        }
        while(!que.isEmpty()) { 
            char ch = que.poll();
            if(cntD == 0)
                return "Radiant";
            if(cntR == 0)
                return "Dire";
            if(ch == 'R'){
                if(revR == 0) {
                    revD++;
                    que.offer(ch);
                } else {
                    revR--;
                    cntR--;
                }
            }
            if(ch == 'D'){
                if(revD == 0) {
                    revR++;
                    que.offer(ch);
                } else {
                    revD--;
                    cntD--;
                }
            }
        }
        return "Radiant";
    }
}