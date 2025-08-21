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

    public void insertTrie(Trie root, String word, int idx) {
        if(idx == word.length()) {
            root.isWord = true;
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

    public boolean searchTrie(Trie root, String word, int idx, boolean pref) {
        if(idx == word.length()) {
            if(root.isWord || pref)
                return true;
            return false;
        } 
        for(Trie node : root.next) {
            if(node.ch == word.charAt(idx))
                return searchTrie(node, word, idx + 1, pref);
        }
        return false;
    }

    public void insert(String word) {
        insertTrie(this, word, 0);
    }
    
    public boolean search(String word) {
        return searchTrie(this, word, 0, false);
    }
    
    public boolean startsWith(String prefix) {
        return searchTrie(this, prefix, 0, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */