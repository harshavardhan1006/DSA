class Solution {
    int emptyCell;
    int paths;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        emptyCell = 1;
        int sr = -1;
        int sc = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) emptyCell++;
                else if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
            }
        }
        paths = 0;
        dfs(sr,sc,grid);
        return paths;
    }
    private void dfs(int sr,int sc,int[][] grid){
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] < 0 || grid[sr][sc] == -2) return;
        if(grid[sr][sc] == 2){
            if(emptyCell == 0) paths++;
            return;
        }
        emptyCell--;
        grid[sr][sc] = -2;
        dfs(sr+1,sc,grid);
        dfs(sr-1,sc,grid);
        dfs(sr,sc+1,grid);
        dfs(sr,sc-1,grid);
        grid[sr][sc] = 0;
        emptyCell++;
    }
}