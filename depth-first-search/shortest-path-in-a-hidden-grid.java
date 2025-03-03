/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * void move(char direction);
 * boolean isTarget();
 * }
 */

class Solution {
    Map<Integer, Integer> vis;
    int INF = Integer.MAX_VALUE / 10;
    public int traverse(GridMaster master, int x, int y) {
        if(master.isTarget())
            return 0;
        int key = x*501 + y;
        if(vis.containsKey(key))
            return vis.get(key);
        vis.put(key, INF);
        // path.add(key);
        int dist = INF;
        if(master.canMove('U')) {
            master.move('U');
            dist = Math.min(dist, 1 + traverse(master, x, y-1));
            master.move('D');
        }
        if(master.canMove('D')) {
            master.move('D');
            dist = Math.min(dist, 1 + traverse(master, x, y+1));
            master.move('U');
        }
        if(master.canMove('L')) {
            master.move('L');
            dist = Math.min(dist, 1 + traverse(master, x-1, y));
            master.move('R');
        }
        if(master.canMove('R')) {
            master.move('R');
            dist = Math.min(dist, 1 + traverse(master, x+1, y));
            master.move('L');
        }
        vis.put(key, dist);
        // path.remove(key);
        return dist;
    }

    public int findShortestPath(GridMaster master) {
        vis = new HashMap<>();
        int ans = traverse(master, 0, 0);
        return ans == INF ? -1 : ans;
    }
}