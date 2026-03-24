class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        long suffix = 1;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                res[i][j] = (int)suffix;
                suffix = (suffix*grid[i][j])%12345;
            }
        }
        long prefix = 1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res[i][j] = (int)(((long)res[i][j]*prefix) % 12345);
                prefix = (prefix*grid[i][j])%12345;
            }
        }
        return res;
    }
}