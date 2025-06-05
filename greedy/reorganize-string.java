class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[0]-a[0]);
        int k = -1;
        int freq[] = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i]!=0)
                pq.offer(new int[] {freq[i], i});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int str[] = pq.poll();
            char ch = (char)('a' + str[1]);
            if(k==-1 || sb.charAt(k) != ch) {
                sb.append(ch);
                if(--str[0]!= 0)
                    pq.offer(str);
            } else {
                if(pq.isEmpty())
                    return "";
                int sec[] = pq.poll();
                sb.append((char)('a' + sec[1]));
                if(--sec[0] != 0)
                    pq.offer(sec);
                pq.offer(str);
            }
            k++;
        }
        return sb.toString();
    }
}