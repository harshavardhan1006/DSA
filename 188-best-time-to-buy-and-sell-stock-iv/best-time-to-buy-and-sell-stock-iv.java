class Solution {
    static int[][][] dp;
    private static int fun(int i,int[] prices,int k,int buy){
        if(k == 0 || i == prices.length) return 0;
        if(dp[i][k][buy] != -1) return dp[i][k][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[i]+fun(i+1,prices,k,0),fun(i+1,prices,k,1));
        }else{
            profit = Math.max(prices[i]+fun(i+1,prices,k-1,1),fun(i+1,prices,k,0));
        }
        return dp[i][k][buy] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][k+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return fun(0,prices,k,1);
    }
}