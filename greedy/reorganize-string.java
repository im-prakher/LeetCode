class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[0]-a[0]);
        int k = -1;
        int freq[] = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(freq[i]!=0)
                pq.offer(new int[] {freq[i], i});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int str[] = pq.poll();
            char ch = (char)('a' + str[1]);
            if(k!=-1 && sb.charAt(k) == ch)
                return "";
            sb.append(ch);
            k++;
            str[0] -= 1;
            if(str[0]!=0)
                pq.offer(str);

        }
        return sb.toString();
    }
}