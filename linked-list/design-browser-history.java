class BrowserHistory {
    class Node {
        String url;
        Node prev, next;
        Node(String _url) {
            url = _url;
        }
    }
    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        curr.next = null;
        Node newPage = new Node(url);
        curr.next = newPage;
        newPage.prev = curr;
        curr = curr.next; 
    }
    
    public String back(int steps) {
        while(steps-- > 0 && curr.prev != null) {
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && curr.next != null) {
            curr = curr.next;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */