class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<n;i++){
            int j = i+1;
            while(j < n && j <= i+nums[i]){
                dp[j] = Math.min(dp[i]+1,dp[j]);
                j++;
            }
        }
        return dp[n-1];
    }
}