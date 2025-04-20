class Solution {
    public int numRabbits(int[] answers) {
        int freq[] = new int[1000]; //color freq map
        int rabbits = 0;
        for(int i = 0; i < answers.length; i++) {
            if(freq[answers[i]] > 0) {
                if(freq[answers[i]] == answers[i])
                    freq[answers[i]] = 0;
                else
                    freq[answers[i]]++;
            } else {
                rabbits += answers[i] + 1;
                if(answers[i] != 0)
                    freq[answers[i]]++;
            }
        }
        return rabbits;
    }
}