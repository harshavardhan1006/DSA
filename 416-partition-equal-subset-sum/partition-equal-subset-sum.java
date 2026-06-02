class Solution {
    private static boolean canDivide(int[] nums,int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(nums[i] <= target){
                    take = dp[i-1][target-nums[i]];
                }
                dp[i][target] = notTake || take;
            }
        }
        return dp[n-1][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums) sum += i;
        if( (sum & 1) == 1) return false;
        sum /= 2;
        return canDivide(nums,sum);
    }
}