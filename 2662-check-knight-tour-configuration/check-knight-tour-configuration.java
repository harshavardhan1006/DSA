class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return isValidMove(0,0,grid,0);
    }
    private boolean isValidMove(int row,int col,int[][] grid,int move){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != move) return false;
        if(move == (grid.length*grid.length)-1) return true;
        return isValidMove(row-1,col+2,grid,move+1) || 
        isValidMove(row-2,col+1,grid,move+1) ||
        isValidMove(row-2,col-1,grid,move+1) || 
        isValidMove(row-1,col-2,grid,move+1) ||
        isValidMove(row+1,col-2,grid,move+1) || 
        isValidMove(row+2,col-1,grid,move+1) || 
        isValidMove(row+2,col+1,grid,move+1) || 
        isValidMove(row+1,col+2,grid,move+1);
    }
}