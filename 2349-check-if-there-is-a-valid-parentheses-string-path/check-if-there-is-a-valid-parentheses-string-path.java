class Solution {
    int[][][] dp;
    int fun(int i,int j,char[][] grid,int cnt){
        if(cnt < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(i == grid.length-1 && j == grid[0].length-1) {
            if(grid[i][j] == ')' && cnt == 1) return 1;
            return 0;
        }
        if(dp[i][j][cnt] != -1) return dp[i][j][cnt];
        // System.out.println(i+" "+j+":"+cnt);
        if(grid[i][j] == '(') return dp[i][j][cnt] = Math.max(fun(i+1,j,grid,cnt+1),fun(i,j+1,grid,cnt+1));
        else return dp[i][j][cnt] = Math.max(fun(i+1,j,grid,cnt-1),fun(i,j+1,grid,cnt-1));
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][m+n-1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        if(grid[0][0] == ')') return false;
        return fun(0,0,grid,0) == 1 ? true : false;
    }
}