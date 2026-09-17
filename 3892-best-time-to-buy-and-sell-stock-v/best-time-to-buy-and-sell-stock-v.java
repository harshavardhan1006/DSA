class Solution {
    static long[][][][] dp;
    private static long fun(int i,int[] prices,int k,int buy,int nbuy){
        if(i == prices.length || k == 0){
            if(buy == 0){
                return (Long.MIN_VALUE)/2;
            }
            return 0;
        }
        if(dp[i][k][buy][nbuy] != -1) return dp[i][k][buy][nbuy];
        long profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[i]+fun(i+1,prices,k,0,0),Math.max(prices[i]+fun(i+1,prices,k,0,1),fun(i+1,prices,k,1,1)));
        }else{
            if(nbuy == 0){
                profit = Math.max(prices[i]+fun(i+1,prices,k-1,1,1),fun(i+1,prices,k,0,0));
            }else{
                profit = Math.max(-prices[i]+fun(i+1,prices,k-1,1,1),fun(i+1,prices,k,0,1));
            }
        }
        return dp[i][k][buy][nbuy] = profit;
    }
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][k+1][2][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j][0][0] = -1;
                dp[i][j][1][0] = -1;
                dp[i][j][0][1] = -1;
                dp[i][j][1][1] = -1;
            }
        }
        return fun(0,prices,k,1,1);
    }
}