class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] box = new char[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                box[j][m-1-i] = boxGrid[i][j];
            }
        }
        m = box.length;
        n = box[0].length;
        int j = 0;
        while(j < n){
            int i = m-1;
            int space = m-1;
            while(i >= 0){
                if(box[i][j] == '*') space = i-1;
                else if(box[i][j] == '#'){
                    box[i][j] = '.';
                    box[space][j] = '#';
                    space--;
                }
                i--;
            }
            j++;
        }
        return box;
    }
}