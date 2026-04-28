class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        n = list.size();
        int operations = 0;
        int mid = n/2;
        int i = 0;
        while(i < n){
            int temp = Math.abs(list.get(mid) - list.get(i));
            if(temp % x != 0) return -1;
            operations += temp/x;
            i++;
        }
        return operations;
    }
}