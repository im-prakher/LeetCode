class Solution {
    public String predictPartyVictory(String senate) {
        int cntR = 0, exR = 0, cntD = 0, exD = 0;
        for(char s : senate.toCharArray()) {
            if(s == 'D') {
                if(cntR > exR)            
                    exR++;
                else 
                    cntD++;
            } else {
                if(cntD > exD)            
                    exD++;
                else 
                    cntR++;
            }
        }
        return (cntD - exD) > (cntR - exR) ? "Dire" : "Radiant";
    }
}