class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[] x = {-1,1,0,0,-1,-1,1,1};
        int[] y = {0,0,-1,1,-1,1,-1,1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        int minPath = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            if(row == n-1 && col == n-1) minPath = Math.min(minPath,dist);
            q.poll();
            for(int i=0;i<8;i++){
                int r = row + x[i];
                int c = col + y[i];
                if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 1) continue;
                grid[r][c] = 1;
                q.add(new Pair(r,c,dist+1));
            }
        }
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }
}