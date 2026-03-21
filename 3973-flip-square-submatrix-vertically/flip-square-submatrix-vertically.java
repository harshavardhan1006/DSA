class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int start = x;
        int end = x+k-1;
        while(start < end){
            int colstart = y;
            int colend = y+k-1;
            while(colstart <= colend){
                int temp = grid[start][colstart];
                grid[start][colstart] = grid[end][colstart];
                grid[end][colstart] = temp;
                colstart++;
            }
            start++;
            end--;
        }
        return grid;
    }
}