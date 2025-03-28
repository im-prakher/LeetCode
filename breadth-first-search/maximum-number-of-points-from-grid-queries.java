class Solution {

    // Directions for movement (down, up, right, left)
    public static final int[][] DIRECTIONS = {
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 },
    };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int queryCount = queries.length;
        int[] result = new int[queryCount];
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int totalCells = rowCount * colCount;
        // Stores the minimum query value needed to reach `i` points.
        int[] thresholdForMaxPoints = new int[totalCells + 1];

        // `minValueToReach[i][j]` keeps track of the maximum value encountered
        // to reach cell (i, j), including itself.
        int[][] minValueToReach = new int[rowCount][colCount];

        // Initialize the minValueToReach array with a high value.
        for (int[] row : minValueToReach) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Start from the top-left cell.
        minValueToReach[0][0] = grid[0][0]; //max encountered value along the path

        // Min-heap for processing cells in increasing order of their maximum
        // encountered value.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(a[2], b[2])
        );
        minHeap.offer(new int[] { 0, 0, grid[0][0] });
        int visitedCells = 0;

        // Dijkstra's algorithm to compute minValueToReach for each cell
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            // Store the value required to reach `visitedCells` points.
            thresholdForMaxPoints[++visitedCells] = current[2];
            // Explore all possible directions.
            for (int[] direction : DIRECTIONS) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                // Check if the new position is within bounds and not visited
                // before.
                if (
                    newRow >= 0 &&
                    newRow < rowCount &&
                    newCol >= 0 &&
                    newCol < colCount &&
                    minValueToReach[newRow][newCol] == Integer.MAX_VALUE
                ) {
                    // The max value encountered on the path to this cell.
                    minValueToReach[newRow][newCol] = Math.max(
                        current[2],
                        grid[newRow][newCol]
                    );

                    // Add the cell to the heap for further exploration.
                    minHeap.offer(
                        new int[] {
                            newRow,
                            newCol,
                            minValueToReach[newRow][newCol],
                        }
                    );
                }
            }
        }

        // Use binary search to determine the maximum number of points that can
        // be collected for each query.
        for (int i = 0; i < queryCount; i++) {
            int threshold = queries[i];
            int left = 0, right = totalCells;

            // Find the rightmost number of points we can collect before
            // exceeding the query threshold.
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (thresholdForMaxPoints[mid] < threshold) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            // Return `left`.
            result[i] = left;
        }

        return result;
    }
}
// tc= klogk +n.mlog(m.n)
// The algorithm first sorts the k queries, which takes O(klogk) time. Then, for each query, it processes cells using a min-heap. In the worst case, all n⋅m cells are processed and pushed into the heap. Each heap operation (push or pop) takes O(log(n⋅m)) time. Therefore, processing all cells takes O(n⋅mlog(n⋅m)).

// sc= n.m+ k
// >>> is the unsigned right shift operator.
// >>> 1 divides by 2, but avoids potential integer overflow.
// Since left + right + 1 is always positive here, >>> 1 behaves identically to / 2 but is safer.
//  int mid = (left + right + 1) >>> 1;
// +1 ensures we round up when left + right is odd, avoiding infinite loops.
// >>> 1 safely divides by 2, preventing signed integer overflow.

//  This binary search is used for finding the largest index where the value is still less than threshold.

// suppose grid as weighted graph use dikjastra to find minquery value to reach k cells or gain k points, but dikstra is slightly updated , we will use max encountered value in path for neighbours, 