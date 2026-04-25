class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] res = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        Arrays.sort(sources, (a,b) -> Integer.compare(b[2],a[2]));
        for(int[] i:sources){
            res[i[0]][i[1]] = i[2];
            queue.add(new int[]{i[0],i[1],i[2]});
            vis[i[0]][i[1]] = true;
        }
        int[] x = {-1,0,0,1};
        int[] y = {0,-1,1,0};
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int i=0;i<4;i++){
                int row = x[i] + arr[0];
                int col = y[i] + arr[1];
                if(row < 0 || col < 0 || row >= n || col >= m || vis[row][col]) continue;
                res[row][col] = arr[2];
                vis[row][col] = true;
                queue.add(new int[]{row,col,arr[2]});
            }
        }
        return res;
    }
}