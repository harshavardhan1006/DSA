class Solution {
    public int getWinner(int[] arr, int k) {
        int cnt = 0;
        int num = arr[0];
        for(int i=1;i<arr.length;i++){
            if(num > arr[i]) cnt++;
            if(cnt == k) return num;
            if(num < arr[i]){
                num = arr[i];
                cnt = 1;
            }
        }
        return num;
    }
}