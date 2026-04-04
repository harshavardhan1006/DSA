class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // if(left.length == 0|| right.length == 0) return n;
        int temp = 0;
        for(int i:left){
            temp = Math.max(temp,i);
        }
        for(int i:right){
            temp = Math.max(temp,n-i);
        }
        return temp;
    }
}