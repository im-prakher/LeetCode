class Trie {
    char ch;
    boolean isWord;
    List<Trie> next;
    
    public Trie(char ch) {
        this.ch =ch;
        isWord = false;
        next = new ArrayList<>();
    } 

    public Trie() {
        isWord = false;
        next = new ArrayList<>();
    }

}

class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void insertTrie(Trie root, String word, int idx) {
        if(idx == word.length()) {
            return;
        }
        char ch = word.charAt(idx);
        for(Trie node : root.next) {
            if(node.ch == ch) {
                insertTrie(node, word, idx + 1);
                return;
            }
        }
        Trie node = new Trie(ch);
        root.next.add(node);
        insertTrie(node, word, idx + 1);
    }
    
    public boolean searchTrie(Trie root, String word, int idx) {
        if(idx == word.length()) {
            return true;
        } 
        char ch = word.charAt(idx);
        boolean res = false;
        for(Trie node : root.next) {
            if(node.ch == ch || ch == '.')
                res |= searchTrie(node, word, idx + 1);
        }
        return res;
    }
    
    public void addWord(String word) {
        insertTrie(root, word, 0);
    }
    
    public boolean search(String word) {
        return searchTrie(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */