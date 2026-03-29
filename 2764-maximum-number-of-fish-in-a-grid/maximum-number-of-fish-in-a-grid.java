class Solution {
    int maxFishes;
    int current;
    public int findMaxFish(int[][] grid) {
        maxFishes = 0;
        // int[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    current = 0;
                    dfs(i,j,grid);
                }
            }
        }
        return maxFishes;
    }
    private void dfs(int i,int j,int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        current += grid[i][j];
        maxFishes = Math.max(maxFishes,current);
        grid[i][j] = 0;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}