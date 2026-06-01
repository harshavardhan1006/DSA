class Solution {
    private static int robbery(int[] nums,int st,int end){
        int[] dp = new int[end+1];
        dp[st] = nums[st];
        dp[st+1] = Math.max(nums[st],nums[st+1]);
        for(int i=st+2;i<=end;i++){
            dp[i] = Math.max(nums[i]+dp[i-2] , dp[i-1]);
        }
        return dp[end];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        return Math.max(robbery(nums,0,n-2),robbery(nums,1,n-1));
    }
}