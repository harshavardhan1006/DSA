class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i] == 0) obstacleGrid[0][i] = 1;
            else{
                for(int j=i;j<n;j++){
                    obstacleGrid[0][j] = -1;
                }
                break;
            }
        }
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0] == 0) obstacleGrid[i][0] = 1;
            else{
                for(int j=i;j<m;j++){
                    obstacleGrid[j][0] = -1;
                }
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                int top = obstacleGrid[i-1][j];
                int left = obstacleGrid[i][j-1];
                obstacleGrid[i][j] = ( top == -1 || left == -1 ) ? Math.max(top,left) : (top+left);
            }
        }
        return obstacleGrid[m-1][n-1] == -1 ? 0 : obstacleGrid[m-1][n-1];
    }
}