class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] len = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            len[i] = 1;
        }
        int maxi = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(1+dp[j] > dp[i]){
                        dp[i] = 1+dp[j];
                        len[i] = len[j];
                    }
                    else if(1+dp[j] == dp[i]) len[i] += len[j];
                }
            }
            maxi = Math.max(dp[i],maxi);
        }
        int res = 0;
        // for(int i:dp) System.out.print(i+" ");
        // System.out.println();
        // for(int i:len) System.out.print(i+" ");
        // System.out.println(maxi);
        for(int i=0;i<n;i++){
            if(maxi == dp[i]){
                res += len[i];
            }
        }
        return maxi == 1 ? n : res;
    }
}