class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0 || !wordList.contains(endWord))
            return 0;
       int cnt=0;
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();

        que.add(beginWord);
        dict.remove(beginWord);
        while(!que.isEmpty()){
            cnt++;
            int size = que.size();
            for(int k=0; k<size; k++){
                String word = que.poll();
                if(word.equals(endWord))
                    return cnt;
                for(int i=0; i<word.length(); i++){
                    for(char ch= 'a'; ch <= 'z'; ch++){
                        char[] arr = word.toCharArray();
                        arr[i] = ch;
                        String midWord = new String(arr);
                        if(dict.contains(midWord)){
                            que.add(midWord);
                            dict.remove(midWord);
                        }
                    }
                }
            }
        }
        return 0; 
    }
}