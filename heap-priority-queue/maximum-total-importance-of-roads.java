class Solution {
    public class Node {
        int v; long e;
        Node(int v, long e) {
            this.v = v;
            this.e = e;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        Node[] adj = new Node[n];
        for(int i =0; i < n; i++)
            adj[i] = new Node(i,0);
        for(int road[] : roads) {
            adj[road[0]].e++;
            adj[road[1]].e++;
        }
        Arrays.sort(adj, (a,b)-> Long.compare(b.e, a.e));
        long sum = 0;
        for(Node node : adj) {
            sum = sum + node.e * n;
            n--;
        }
        return sum;
    }
}