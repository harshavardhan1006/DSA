class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean temp = false;
        int[] prefix = new int[n];
        boolean[] x = new boolean[n];
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                if(j > 0 && x[j-1] == true) x[j] = true;
                if(grid[i][j] == 'X'){
                    prefix[j] += 1;
                    x[j] = true;
                }
                else if(grid[i][j] == 'Y') prefix[j] -= 1;
                sum += prefix[j];
                if(sum == 0 && x[j]) res += 1;
            }
        }
        return res;
    }
}