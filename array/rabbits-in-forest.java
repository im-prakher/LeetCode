class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mp = new HashMap<>(); //color freq map
        int rabbits = 0;
        for(int i = 0; i < answers.length; i++) {
            if(mp.containsKey(answers[i])) {
                if(mp.get(answers[i]) == answers[i])
                    mp.remove(answers[i]);
                else
                    mp.put(answers[i], mp.getOrDefault(answers[i], 0) + 1);
            } else {
                rabbits += answers[i] + 1;
                mp.put(answers[i], 1);
            }
        }
        return rabbits;
    }
}