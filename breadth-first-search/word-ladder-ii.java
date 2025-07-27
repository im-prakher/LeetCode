class Solution {
    public int bfs(String beginWord, String endWord, List<String> wordList) {
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
                    return cnt-1;
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

    public void dfs(String word, String endWord, Set<String> dict, int depth, List<List<String>> ans, List<String> res) {
        if(word.equals(endWord)) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if(depth == 0)
            return;
        char[] str = word.toCharArray();
        for(int i = 0; i < str.length; i++) {
            char org = str[i];
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(ch == str[i])
                    continue;
                str[i] = ch;
                String midWord = new String(str);
                if(dict.contains(midWord)) {
                    res.add(midWord);
                    dict.remove(midWord);
                    dfs(midWord, endWord, dict, depth-1, ans, res);
                    dict.add(midWord);
                    res.remove(res.size()-1);
                }
            }
            str[i] = org;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // bfs to find count of steps for shortest transformation
        int depth = bfs(beginWord, endWord, wordList);
        // dfs to use this count to get list of shortest transformation   
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add(beginWord);
        Set<String> dict = new HashSet<>(wordList);
        dfs(beginWord, endWord, dict, depth, ans, res);
        return ans;
    }
}