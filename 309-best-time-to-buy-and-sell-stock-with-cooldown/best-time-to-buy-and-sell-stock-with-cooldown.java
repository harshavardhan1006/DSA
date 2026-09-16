class Solution {
    static int[][] dp;
    private static int fun(int i,int[] prices,int buy){
        if(i >= prices.length) return 0;
        int profit = 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        // System.out.println(i);
        if(buy == 1){
            profit = Math.max(-prices[i]+fun(i+1,prices,0),fun(i+1,prices,1));
        }else{
            profit = Math.max(prices[i]+fun(i+2,prices,1),fun(i+1,prices,0));
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun(0,prices,1);
    }
}