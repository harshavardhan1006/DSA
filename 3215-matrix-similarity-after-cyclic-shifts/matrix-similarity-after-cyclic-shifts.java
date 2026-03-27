class Solution {
    private void reverse(int[] arr,int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
    private boolean isCheck(int[] arr,int k){
        int[] newarr = new int[arr.length];
        int j=0;
        for(int i:arr) newarr[j++] = i;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,arr.length-k-1);
        reverse(arr,arr.length-k,arr.length-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i] != newarr[i]) return false;
        }
        return true;
    }
    private boolean isValid(int[] arr,int k){
        int[] newarr = new int[arr.length];
        int j=0;
        for(int i:arr) newarr[j++] = i;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i] != newarr[i]) return false;
        }
        return true;
    }
    public boolean areSimilar(int[][] mat, int k) {
        k = k % mat[0].length;
        for(int i=0;i<mat.length;i++){
            if((i & 1) == 1){
                if(!isCheck(mat[i],k)) return false;
            }else{
                if(!isValid(mat[i],k)) return false;
            }
        }
        return true;
    }
}