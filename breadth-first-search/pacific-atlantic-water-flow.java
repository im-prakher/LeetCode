class Solution {
    public class Flow{
        boolean atl;
        boolean pac;
        public Flow() {
            atl = pac = false;
        }
    }

    // void pacificFlow(int i, int j, Flow[][] flow, int[][] heights) {
    //     int n = heights.length, m = heights[0].length;
    //     if(i == 0 && j == 0)
    //         return;
    //     flow[i][j].pac = true;
        
    //         res.add(List.of(i, j));
    //     if(j != m-1 && j != 0 && heights[i][j+1] >= heights[i][j]) {
    //         pacificFlow(i, j+1, flow, heights);
    //     }
    //     if(i != n-1 && i != 0 && heights[i+1][j] >= heights[i][j]) {
    //         pacificFlow(i+1, j, flow, heights);
    //     }
    // }

    // void atlanticFlow(int i, int j, Flow[][] flow, int[][] heights) {
    //     int n = heights.length, m = heights[0].length;
    //     if(i == n-1 && j == m-1)
    //         return;
    //     flow[i][j].atl = true;
    //     if(flow[i][j].pac)
    //         res.add(List.of(i, j));
    //     if(j != 0 && j != m-1 && heights[i][j-1] >= heights[i][j]) {
    //         atlanticFlow(i, j-1, flow, heights);
    //     }
    //     if(i != 0 && i != n-1 && heights[i-1][j] >= heights[i][j]) {
    //         atlanticFlow(i-1, j, flow, heights);
    //     }
    // }

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 1 || m <= 1) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    res.add(List.of(i, j));
                }
            }
            return res;
        }
        Flow[][] flow = new Flow[n][m];   
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                flow[i][j] = new Flow();
            }
        }
        for(int i = 0; i < n; i++) {
            flow[i][0].pac = true;
            flow[i][m-1].atl = true;
        }

        for(int i = 0; i < m; i++) {
            flow[0][i].pac = true;
            flow[n-1][i].atl = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(mat[i][j] >= mat[i-1][j]) {
                    flow[i][j].pac = flow[i-1][j].pac;
                }
                if(mat[i][j] >= mat[i][j-1]) {
                    flow[i][j].pac = flow[i][j-1].pac;
                }
            }
        }

        for(int i = n-2; i >= 0; i--) {
            for(int j = m-2; j >= 0; j--) {
                if(mat[i][j] >= mat[i+1][j]) {
                    flow[i][j].atl = flow[i+1][j].atl;
                }
                if(mat[i][j] >= mat[i][j+1]) {
                    flow[i][j].atl = flow[i][j+1].atl;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(flow[i][j].atl && flow[i][j].pac)
                    res.add(List.of(i, j));
            }
        }
        return res;
    }
}