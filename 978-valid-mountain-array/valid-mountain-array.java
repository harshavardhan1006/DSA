class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        if(arr[0] >= arr[1]) return false;
        boolean flag = true;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1]) return false;
            if(flag){
                if(arr[i] < arr[i-1]) flag = false;
            }else{
                if(arr[i] >= arr[i-1]) return false;
            }
        }
        if(flag) return false;
        return true;
    }
}