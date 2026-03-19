class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] prefix = new int[n];
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                prefix[j] += grid[i][j];
                sum += prefix[j];
                if(sum <= k) res += 1;
            }
        }
        return res;
    }
}