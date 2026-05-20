class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] x = { -1, 1, 0, 0 };
        int[] y = { 0, 0, -1, 1 };
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area += 4;
                    for (int z = 0; z < 4; z++) {
                        int row = i + x[z];
                        int col = j + y[z];
                        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
                            continue;
                        if (grid[row][col] == 1)
                            area--;
                    }
                }
            }
        }
        return area;
    }
}