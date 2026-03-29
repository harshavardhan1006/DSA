class Solution {
    int maxArea;
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        maxArea = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    area = 0;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return maxArea;
    }
    void dfs(int i,int j,int[][] grid,boolean[][] vis){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) return;
        area++;
        vis[i][j] = true;
        maxArea = Math.max(area,maxArea);
        dfs(i+1,j,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j-1,grid,vis);
        dfs(i,j+1,grid,vis);
    }
}