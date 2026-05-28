class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowSize = triangle.size();
        int colSize = 2;
        for(int i=1;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(j == 0){
                    int temp = triangle.get(i).get(j) + triangle.get(i-1).get(0);
                    triangle.get(i).set(j,temp);
                }else if(j == colSize-1){
                    int temp = triangle.get(i).get(j) + triangle.get(i-1).get(colSize-2);
                    triangle.get(i).set(j,temp);
                }else{
                    int current = triangle.get(i).get(j);
                    int temp = Math.min(triangle.get(i-1).get(j-1) + current,triangle.get(i-1).get(j) + current);
                    triangle.get(i).set(j,temp);
                }
                // System.out.print(triangle.get(i).get(j) + " ");
            }
            // System.out.println();
            colSize++;
        }
        int i = rowSize - 1;
        int res = Integer.MAX_VALUE;
        for(int j=0;j<colSize-1;j++){
            res = Math.min(triangle.get(i).get(j) , res);
        }
        return res;
    }
}