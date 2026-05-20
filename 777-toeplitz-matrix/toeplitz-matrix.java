class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer,Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(i-j)){
                    if(map.get(i-j) != matrix[i][j]) return false;
                }
                else{
                    map.put((i-j),matrix[i][j]);
                }
            }
        }
        return true;
    }
}