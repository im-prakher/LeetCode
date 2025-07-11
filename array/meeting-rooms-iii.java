class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        TreeMap<Integer, TreeSet<Integer>> tmap = new TreeMap<>();
        Arrays.sort(meetings, (a, b)-> a[0] - b[0]);
        int rdx = 0;
        for(int[] meeting : meetings) {
            if(rdx != n) {
                tmap.putIfAbsent(meeting[1], new TreeSet<>());
                tmap.get(meeting[1]).add(rdx); 
                rooms[rdx]++;
                rdx++;
            } else {
                int start = tmap.firstKey();
                TreeSet<Integer> set = tmap.get(start);
                int room = set.first(), intv = start - meeting[0];
                intv = intv > 0 ? intv : 0;
                rooms[room]++;
                set.remove(room); 
                if(set.isEmpty())
                    tmap.remove(start);
                else
                    tmap.put(start, set);
                tmap.putIfAbsent(meeting[1]+intv, new TreeSet<>());
                tmap.get(meeting[1]+intv).add(room);
            }
        }
        int idx = 0, max = rooms[0];
        for(int i = 1; i < n; i++) {
            if(rooms[i] > max) {
                idx  = i;
                max = rooms[i];
            }
        }
        return idx;
    }
}