class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int min = 1;
        int a = points[0][0];
        for(int i=1;i<points.length;i++){
            if(points[i][0] - a > w){
                min++;
                a = points[i][0];
            }
        }
        return min;
    }
}