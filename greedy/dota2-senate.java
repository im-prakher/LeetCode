class Solution {
    public String predictPartyVictory(String senate) {
        int cntR = 0, revR= 0, exR = 0, cntD = 0, exD = 0, revD= 0;
        for(char s : senate.toCharArray()) {
            if(s == 'D') {
                if(cntR > exR) {
                    exR++;
                    revD++;
                } else if(revR < cntR) {
                    exD++;
                    revR++;
                }
                cntD++;
            } else {
                if(cntD > exD) {
                    exD++;
                    revR++;
                } else if(revD < cntD) {
                    exR++;
                    revD++;
                }
                cntR++;
            }
        }
        return (cntD - revD - exR) > (cntR - revR - exD) ? "Dire" : "Radiant";
    }
}