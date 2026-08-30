class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        int maxInd = -1;
        for(int i=0;i<n;i++){
            int temp = nums[i];
            if(temp < min){
                min = temp;
                minInd = i;
            }
            if(temp > max){
                max = temp;
                maxInd = i;
            }
        }
        int a = Math.max(minInd,maxInd)+1;
        int b = n-Math.min(minInd,maxInd);
        int c = Math.min(minInd+1,n-minInd) + Math.min(maxInd+1,n-maxInd);
        return Math.min(a,Math.min(b,c));
    }
}