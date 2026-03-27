class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                total += grid[i][j];
            }
        }
        // horizontal cut 
        if(grid.length > 1){
        long hsum = 0;
        for(int i=0;i<grid.length-1;i++){
            for(int j=0;j<grid[0].length;j++){
                hsum += grid[i][j];
            }
            if(hsum == (total-hsum)) return true;
        }
        }
        // vertical cut
        if(grid[0].length <= 1) return false;
        long vsum = 0;
        for(int i=0;i<grid[0].length-1;i++){
            for(int j=0;j<grid.length;j++){
                vsum += grid[j][i];
            }
            if(vsum == (total-vsum)) return true;
        }
        return false;
    }
}