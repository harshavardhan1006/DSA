class Solution {
    private int calMin(int i,int j,int[][] grid,int k){
        List<Integer> li = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int x=i;x<(k+i);x++){
            for(int y=j;y<(k+j);y++){
                if(!set.contains(grid[x][y])){
                    li.add(grid[x][y]);
                    set.add(grid[x][y]);
                }
            }
        }
        // for(int x=j;x<(k+j);x++){
        //     li.add(grid[x][j]);
        // }
        if(li.size() == 1) return 0;
        Collections.sort(li);
        System.out.println(li);
        int min = Integer.MAX_VALUE;
        for(int x=1;x<li.size();x++){
            min = Math.min(min,Math.abs(li.get(x)-li.get(x-1)));
        }
        return min;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m-k+1][n-k+1];
        for(int i=0;i<m;i++){
            if((m-i) < k) break;
            for(int j=0;j<n;j++){
                if((n-j) < k) break;
                res[i][j] = calMin(i,j,grid,k);
            }
        }
        return res;
    }
}