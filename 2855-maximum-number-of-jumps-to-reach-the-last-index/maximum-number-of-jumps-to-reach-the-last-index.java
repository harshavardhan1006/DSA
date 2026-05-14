class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=0;i<n;i++){
            if(i != 0 && dp[i] == 0) continue;
            for(int j=i+1;j<n;j++){
                if(nums[j]-nums[i] <= target && nums[j] - nums[i] >= -target){
                    dp[j] = Math.max(dp[i] + 1,dp[j]);
                }
            }
        }
        return dp[n-1] == 0 ? -1 : dp[n-1];
    }
}